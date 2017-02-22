package com.tianjunwei.redirect;

import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/book")
@SessionAttributes(value ={"book","description"},types={Double.class})
public class RedirectController {
	
	@RequestMapping("/index")
	public String index( String flashMap,Model model,RedirectAttributes attr){
		attr.addAttribute("attributeName", "attributeValue");
		model.addAttribute("book", "金刚经");
		model.addAttribute("description","不擦擦擦擦擦擦擦车"+new Random().nextInt(100));
		model.addAttribute("price", new Double("1000.00"));
		model.addAttribute("attributeName1", "attributeValue1");
		//跳转之前将数据保存到book、description和price中，因为注解@SessionAttribute中有这几个参数
		attr.addFlashAttribute("flashMap", flashMap);
		return "redirect:get.action";
	}
	
	@ResponseBody
	@RequestMapping("/get")
	public String get(@ModelAttribute ("book") String book,ModelMap model,@ModelAttribute("attributeName") String attributeName,
			@ModelAttribute("attributeName1") String attributeName1,SessionStatus sessionStatus,@ModelAttribute("flashMap") String flashMap){
		
		return flashMap ;
	}
	
	@RequestMapping("/complete")
	public String complete(ModelMap modelMap){
		//已经被清除，无法获取book的值
		System.out.println(modelMap.get("book"));
		modelMap.addAttribute("book", "妹纸");
		return "sessionAttribute";
	}
	
	@RequestMapping("/session")
	public Object session(HttpServletRequest request,String name){
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		return name;
	}
	
	@ResponseBody
	@RequestMapping("/getsession")
	public Object getsession(HttpServletRequest request){
		HttpSession session = request.getSession();
		return session.getAttribute("name");
	}
	

}

