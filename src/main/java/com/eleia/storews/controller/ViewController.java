package com.eleia.storews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/view-products")
    public String viewProducts(){
        return "view-products";
    }

    @RequestMapping("add-product")
    public String addProduct(){
        return "add-product";
    }
}
