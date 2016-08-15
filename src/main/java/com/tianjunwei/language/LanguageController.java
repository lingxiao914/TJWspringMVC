package com.tianjunwei.language;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import tianjunwei.cache.redis.RedisTemplate;

@Controller
public class LanguageController {

	@Autowired
	RedisTemplate redisTemplate;
	
	@RequestMapping("/language")
	public String language(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("user", "tian");
		String language = (String) request.getAttribute("language");
		RequestContext requestContext = new RequestContext(request);
		model.addAttribute("message", requestContext.getMessage("message"));
		model.addAttribute("language", language);
		return "jsp/language";
	}

}
