package com.monitor.core.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.monitor.core.bean.model.ResultModel;
import com.monitor.core.utils.WebUtil;
import com.monitor.core.bean.enums.ResultMessageEnum;
/**
 * 异常错误处理器
 * @author ibett
 *
 */
public class ExceptionHandler implements HandlerExceptionResolver {
	private final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	public ModelAndView resolveException(HttpServletRequest req,
			HttpServletResponse resp, Object obj, Exception e) {
		//出现错误，需区分ajax还是其他请求
		logger.error("------程序出现错误");
		if(WebUtil.isAjax(req)){
			ResultModel result = new ResultModel(ResultMessageEnum.SYSTEM_EXCEPTION);
			WebUtil.writeJson(resp, JSON.toJSONString(result));
		}else{
			return new ModelAndView("error/error");
		}
		return null;
	}

}
