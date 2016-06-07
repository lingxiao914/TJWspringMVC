package com.tianjunwei.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tianjunwei.domain.Product;
import com.tianjunwei.form.ProductForm;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping(value = "input")
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm";  //对应jsp页面名称
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
        return "ProductDetails";//对应jsp页面名称
    }
    
    @ResponseBody
	@RequestMapping("/get")
	public String get(){
		Product product = new Product();
		product.setDescription("hello swdf2 springMVC  RestFul");
		product.setId(10);
		product.setName("swdf2");
		product.setPrice(10);
		return JSON.toJSONString(product); //在页面中返回json数据
	}
    @ResponseBody
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id){
		Product product = new Product();
		product.setDescription("hello swdf2 springMVC  RestFul");
		product.setId(id);
		product.setName("swdf2");
		product.setPrice(10);
		return JSON.toJSONString(product);//在页面中返回json数据
	}
    
}
