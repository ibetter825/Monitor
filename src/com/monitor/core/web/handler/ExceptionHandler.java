package com.monitor.core.web.handler;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import com.monitor.core.bean.model.ResultModel;
import com.monitor.core.exception.AuthenticationException;
import com.monitor.core.exception.ValidateException;
import com.monitor.core.utils.WebUtil;
import com.monitor.core.bean.constant.AuthConstant;
import com.monitor.core.bean.constant.WebConstant;
import com.monitor.core.bean.enums.ResultMessageEnum;
/**
 * 异常错误处理器
 * @author ibett
 *
 */
public class ExceptionHandler implements HandlerExceptionResolver {
	private final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	public static final String DEFAULT_ERROR_PATH = "/error/error";
	
	public ModelAndView resolveException(HttpServletRequest req,
			HttpServletResponse resp, Object obj, Exception e) {
		try {
    		if(WebUtil.isAjax(req))
        		exceptionHandle(resp, e);
    		else{
    	        ModelAndView mav = new ModelAndView();
    	        if(e instanceof AuthenticationException){
    	        	mav.setViewName("/login");
    	        }else{
	    	        mav.addObject("exception", e);
	    	        mav.addObject("url", req.getRequestURL());
	    	        mav.setViewName(DEFAULT_ERROR_PATH+"/500");
    	        }
    	        return mav;
    		}
		} catch (IOException e1) {
			//需要处理一下
			e1.printStackTrace();
		} finally {
			if(!(e instanceof AuthenticationException))
				logger.error("ExceptionHandler.class", e);
		}
        return null;
	}
	 public void exceptionHandle(HttpServletResponse resp, Exception e) throws IOException{
	    	ServletOutputStream outer = null;
	    	boolean isTkValiEx = e instanceof ValidateException;//是否是表单验证错误
			try {
				ResultModel model = null;
				resp.reset();
				outer = resp.getOutputStream();
				if(isTkValiEx){
					resp.setStatus(HttpStatus.OK.value());
					model = new ResultModel(e.getMessage());
					model.getData().put(AuthConstant.FORM_VALI_FAIL_NAME, ((ValidateException) e).getError());
				}else{
					resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					model = new ResultModel(ResultMessageEnum.SYSTEM_EXCEPTION);
				}
				resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
				resp.setCharacterEncoding(WebConstant.DEFAULT_ENCODING); //避免乱码
				resp.setHeader("Cache-Control", "no-cache, must-revalidate");
				String res = JSON.toJSONString(model);
				outer.write(res.getBytes(WebConstant.DEFAULT_ENCODING));
				outer.flush();
			} finally {
				if(outer != null) outer.close();
			}
	    }
}
