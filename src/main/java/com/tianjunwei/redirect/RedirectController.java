package com.tianjunwei.redirect;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
@SessionAttributes(value ={"book","description"},types={Double.class})
public class RedirectController {
	
	@RequestMapping("/index")
	public String index(Model model,RedirectAttributes attr){
		attr.addAttribute("attributeName", "attributeValue");
		model.addAttribute("book", "金刚经");
		model.addAttribute("description","不擦擦擦擦擦擦擦车"+new Random().nextInt(100));
		model.addAttribute("price", new Double("1000.00"));
		model.addAttribute("attributeName1", "attributeValue1");
		//跳转之前将数据保存到book、description和price中，因为注解@SessionAttribute中有这几个参数
		return "redirect:get.action";
	}
	
	@RequestMapping("/get")
	public String get(@ModelAttribute ("book") String book,ModelMap model,@ModelAttribute("attributeName") String attributeName,
			@ModelAttribute("attributeName1") String attributeName1,SessionStatus sessionStatus){
		//可以获得book、description和price的参数
		System.out.println(model.get("book")+";"+model.get("description")+";"+model.get("price"));
		sessionStatus.setComplete();
		System.out.println(attributeName);
		System.out.println(attributeName1);
		return "redirect:complete.action";
	}
	
	@RequestMapping("/complete")
	public String complete(ModelMap modelMap){
		//已经被清除，无法获取book的值
		System.out.println(modelMap.get("book"));
		modelMap.addAttribute("book", "妹纸");
		return "sessionAttribute";
	}

}

