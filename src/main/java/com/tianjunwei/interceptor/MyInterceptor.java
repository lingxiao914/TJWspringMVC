package com.tianjunwei.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*  spring MVC中配置拦截器**/
/**
<mvc:interceptors>  
    <mvc:interceptor>  
        <mvc:mapping path="/*"/>  
        <bean class="interceptor.MyInterceptor"/>
    </mvc:interceptor>  
</mvc:interceptors>
*/
public class MyInterceptor implements HandlerInterceptor {

	/**
	 * @Title: preHandle
	 * @Description: 在执行controller之前运行
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception 
	 */ 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return true;
	}
	
	/**
	 * @Title: postHandle
	 * @Description: 在执行完controller之后，ModelAndView渲染之前开始运行
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception 
	 */ 
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
	        throws Exception {
	}
	
	/**
	 * @Title: afterCompletion
	 * @Description: 该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图后执行
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception 
	 */ 
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	        throws Exception {
	}
	
}