package com.monitor.core.web.controller;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.monitor.core.bean.constant.WebConstant;


@RestController
@RequestMapping("/u")
public class BaseController {
	/**
	 * 视图根路径
	 */
	public final static String VIEW_CORE_PATH = "core/";
	public final static String VIEW_DATA_PATH = "data/";
	@Autowired  
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	/**
	 * 添加request请求属性
	 * @param key
	 * @param val
	 */
	public void setAttr(String key, Object val){
		request.setAttribute(key, val);
	}
	/**
	 * 获取request请求属性
	 * @param key
	 * @return
	 */
	public Object getAttr(String key){
		return request.getAttribute(key);
	}
	/**
	 * 向前端写出json
	 * @param data
	 * @throws IOException 
	 */
	public void renderJson(Object data) throws IOException{
		ServletOutputStream outer = null;
		try {
			response.reset();
			outer = response.getOutputStream();
			response.setStatus(HttpStatus.OK.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding(WebConstant.DEFAULT_ENCODING); //避免乱码
			response.setHeader("Cache-Control", "no-cache, must-revalidate");
			String res = JSON.toJSONString(data);
			outer.write(res.getBytes(WebConstant.DEFAULT_ENCODING));
			outer.flush();
		} finally {
			if(outer != null) outer.close();
		}
	}
	
}
