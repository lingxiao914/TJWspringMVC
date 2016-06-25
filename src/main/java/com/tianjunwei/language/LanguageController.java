package com.tianjunwei.language;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class LanguageController {

	@RequestMapping("/language")
	public String language(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("user", "tian");
		String language = request.getParameter("language");
		if (language != null&&language.equals("zh")) {
			Locale locale = new Locale("zh", "CN");
			request.getSession()
					.setAttribute(
							SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
							locale);
		} else if (language != null&&language.equals("en")) {
			Locale locale = new Locale("en", "US");
			request.getSession()
					.setAttribute(
							SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
							locale);
		} else {
			request.getSession().setAttribute(
					SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
					LocaleContextHolder.getLocale());
		}
		RequestContext requestContext = new RequestContext(request);
		model.addAttribute("language", requestContext.getMessage("message"));
		return "language";
	}

}
