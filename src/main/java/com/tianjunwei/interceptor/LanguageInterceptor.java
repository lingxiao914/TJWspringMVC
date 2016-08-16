package com.tianjunwei.interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class LanguageInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String language = request.getParameter("language");
		if (language != null&&language.equals("zh")) {
			Locale locale = new Locale("zh", "CN");
			request.getSession()
					.setAttribute(
							SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
							locale);
			request.setAttribute("language", language);
		} else if (language != null&&language.equals("en")) {
			Locale locale = new Locale("en", "US");
			request.getSession()
					.setAttribute(
							SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
							locale);
			request.setAttribute("language", language);
		} else {
			request.getSession().setAttribute(
					SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
					LocaleContextHolder.getLocale());
			language = LocaleContextHolder.getLocale().getLanguage();
			request.setAttribute("language", language);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
