package com.tianjunwei.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sun.beans.editors.LongEditor;
import com.sun.org.apache.xml.internal.security.Init;
import com.tianjunwei.controller.entity.Product;
import com.tianjunwei.controller.entity.ProductForm;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Log logger = LogFactory.getLog(ProductController.class);

    @InitBinder    
    protected void initBinder(WebDataBinder binder) {    
    	 binder.registerCustomEditor(long.class, new LongEditor());
    }   
    
    @ModelAttribute
    public void init(){
    	System.out.println("init");
    }
    
    
    @RequestMapping(value = "input")
    public String inputProduct() {
        logger.info("inputProduct called");
        return "jsp/ProductForm";  //对应jsp页面名称
    }
    
    @RequestMapping(value="/save")
    public String saveProduct(ProductForm productForm, Model model) {
        logger.info("saveProduct called");
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(Float.parseFloat(
                    productForm.getPrice()));
        } catch (NumberFormatException e) {
        }
        model.addAttribute("product", product);
        return "jsp/ProductDetails";//对应jsp页面名称
    }
    
    @ResponseBody
	@RequestMapping("/get")
	public Object get(){
		Product product = new Product();
		product.setDescription("hello  springMVC  RestFul");
		product.setId(10);
		product.setName("springMVC");
		product.setPrice(10);
		return product; //在页面中返回json数据
	}
    @ResponseBody
	@RequestMapping("/delete/{id}")
	public Object delete(@PathVariable("id") long id){
		Product product = new Product();
		product.setDescription("hello  springMVC  RestFul");
		product.setId(id);
		product.setName("springMVC");
		product.setPrice(10);
		return product;//在页面中返回json数据
	}
    
}