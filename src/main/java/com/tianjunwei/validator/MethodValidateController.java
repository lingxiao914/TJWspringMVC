package com.tianjunwei.validator;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tianjunwei.validator.service.ValidatorTestService;

@Controller
public class MethodValidateController {

	@Autowired
	ValidatorTestService validatorTestService;
	
	@RequestMapping(value="/method", method = {RequestMethod.GET})
    public String method(){
        return "method";
    }
    
    @RequestMapping(value="/methodsave")
    public String test5(String name, String password, Model model){
        try {
            String content = validatorTestService.getContent(name, password);
            model.addAttribute("name", content);
        } catch (ConstraintViolationException e) {
        	System.err.println(e);
            addErrorMessage(model, e);
        }
        return "method";
    }
    protected void addErrorMessage(Model model, ConstraintViolationException e){
        Map<String, String> errorMsg = new HashMap<String,String>();
        model.addAttribute("errorMsg", errorMsg);

        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            // 获得验证失败的类 constraintViolation.getLeafBean()
            // 获得验证失败的值 constraintViolation.getInvalidValue()
            // 获取参数值 constraintViolation.getExecutableParameters()
            // 获得返回值 constraintViolation.getExecutableReturnValue()
            errorMsg.put(constraintViolation.getLeafBean().getClass().getName() + "-" + constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        }
    }
}
