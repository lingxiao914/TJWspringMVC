package com.tianjunwei.validator;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import com.tianjunwei.validator.entity.ValidateModel;
import com.tianjunwei.validator.service.ValidatorTestService;

@Controller
@RequestMapping(value = "/validate")
public class ValidateController {
	
	
	
    @RequestMapping(value="/form", method = {RequestMethod.GET})
    public String test(Model model){

        if(!model.containsAttribute("contentModel")){
            model.addAttribute("contentModel", new ValidateModel());
        }
        return "validator/validatetest";
    }
    
    @RequestMapping(value="/form", method = {RequestMethod.POST})
    public String test(HttpServletRequest request,Model model, @Valid @ModelAttribute("contentModel") ValidateModel validateModel, BindingResult result) throws NoSuchAlgorithmException{
        
        //如果有验证错误 返回到form页面
        if(result.hasErrors())
            return test(model);
        RequestContext requestContext = new RequestContext(request);
		model.addAttribute("success", requestContext.getMessage("success"));
        return "validator/validatesuccess";     
    }
    
    
    
    
}
