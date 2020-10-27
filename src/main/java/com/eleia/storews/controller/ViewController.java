package com.eleia.storews.controller;

import com.eleia.storews.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @Autowired
    ProductWs productWs;

    @RequestMapping("/view-products")
    public String viewProducts(){
        return "view-products";
    }

    @RequestMapping("add-product")
    public String addProduct(){
        return "add-product";
    }
    @GetMapping("/create-product")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "create-product";
    }

    @PostMapping("/create-product")
    public String addProduct(@ModelAttribute Product product, Model model){
        model.addAttribute("product", product);
        productWs.createProduct(product);
        return "view-products";
    }
}
