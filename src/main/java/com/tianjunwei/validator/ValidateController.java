package com.tianjunwei.validator;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianjunwei.validator.entity.ValidateModel;

@Controller
@RequestMapping(value = "/validate")
@Validated
public class ValidateController {
	
	@ResponseBody
    @RequestMapping(value = "/validString", method = RequestMethod.GET)
    public String validString(
            @RequestParam(value = "str", defaultValue = "")
            @Size(min = 1, max = 3)
            String vStr){

        return vStr;
    }
	
	
    @RequestMapping(value="/form", method = {RequestMethod.GET})
    public String test(Model model){

        if(!model.containsAttribute("contentModel")){
            model.addAttribute("contentModel", new ValidateModel());
        }
        return "validator/validatetest";
    }
    
    @RequestMapping(value="/form", method = {RequestMethod.POST})
    public String test(Model model, @Valid @ModelAttribute("contentModel") ValidateModel validateModel, BindingResult result) throws NoSuchAlgorithmException{
        
        //如果有验证错误 返回到form页面
        if(result.hasErrors())
            return test(model);
        return "validator/validatesuccess";     
    }
    
    
    
    
}
