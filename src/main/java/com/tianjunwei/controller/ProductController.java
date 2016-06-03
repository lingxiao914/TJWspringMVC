package com.tianjunwei.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tianjunwei.domain.Product;
import com.tianjunwei.form.ProductForm;

@Controller
public class ProductController {

    private static final Log logger = LogFactory.getLog(ProductController.class);
    final String URL = "/product_input";

    @RequestMapping(value = URL)
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm";
    }
    
    @RequestMapping(value="/product_save")
    public String saveProduct(ProductForm productForm, Model model) {
        logger.info("saveProduct called");
        // no need to create and instantiate a ProductForm
        // create Product
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(Float.parseFloat(
                    productForm.getPrice()));
        } catch (NumberFormatException e) {
        }

        // add product

        model.addAttribute("product", product);
        return "ProductDetails";
    }
}
