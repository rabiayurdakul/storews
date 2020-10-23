package com.eleia.storews.controller;

import com.eleia.storews.exception.ProductNotFoundException;
import com.eleia.storews.model.Product;
import com.eleia.storews.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductWs {

    @Autowired
    IProductService productService;



    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }


    @RequestMapping(value="/products", method= RequestMethod.POST)
    public  ResponseEntity<Object> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created sucessfully", HttpStatus.CREATED);

    }

    @RequestMapping(value="/products/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){

        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);


    }

    @RequestMapping(value="/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(@PathVariable("id") String id){
        return new ResponseEntity<>(productService.getProduct(id),HttpStatus.OK);

    }



}
