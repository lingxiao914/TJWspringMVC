package com.tianjunwei.language;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class LanguageController {

	
	@RequestMapping("/language")
	public String language(HttpServletRequest request, Model model) {
		String language = request.getParameter("language");
		RequestContext requestContext = new RequestContext(request);
		model.addAttribute("message", requestContext.getMessage("message"));
		if(StringUtils.isEmpty(language)){
			language = "zh";
		}
		model.addAttribute("language", language);
		return "jsp/language";
	}

}
