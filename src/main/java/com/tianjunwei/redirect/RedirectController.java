package com.tianjunwei.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/book")
@SessionAttributes(value ={"book","description"},types={Double.class})
public class RedirectController {
	
	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("book", "金刚经");
		model.addAttribute("description","不擦擦擦擦擦擦擦车");
		model.addAttribute("price", new Double("1000.00"));
		return "redirect:get.action";
	}
	
	@RequestMapping("/get")
	public String get(@ModelAttribute ("book") String book,ModelMap model,SessionStatus sessionStatus){
		System.out.println(model.get("book")+";"+model.get("description")+";"+model.get("price"));
		sessionStatus.setComplete();
		return "redirect:complete.action";
	}
	
	@RequestMapping("/complete")
	public String complete(ModelMap modelMap){
		System.out.println(modelMap.get("book"));
		return "index";
	}

}
