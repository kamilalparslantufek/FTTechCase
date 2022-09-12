package com.patikacase.firstcase.controllers;


import com.patikacase.firstcase.models.Comment;
import com.patikacase.firstcase.models.Product;
import com.patikacase.firstcase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public Product InsertProduct(){
        var product = new Product(UUID.randomUUID().toString(),"P2",23.2);
        productRepository.save(product);
        return product;
    }

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public List<Comment> ProductComments(@PathVariable("id") String ProductId){
        return productRepository.findById(ProductId).get().getComments();
    }

    @RequestMapping(value = "expired", method = RequestMethod.GET)
    public List<Product> ExpiredProducts(){
        var e = new ArrayList<Product>();
        for(var obj : productRepository.findAll()){
            if(obj.getExpirationDate() != null && obj.getExpirationDate().before(new Date(System.currentTimeMillis()))) e.add(obj);
        }
        return e;
    }

    @RequestMapping(value = "fresh", method = RequestMethod.GET)
    public List<Product> FreshProducts(){
        var e = new ArrayList<Product>();
        for(var obj : productRepository.findAll()){
            if(obj.getExpirationDate() == null || obj.getExpirationDate().after(new Date(System.currentTimeMillis()))) e.add(obj);
        }
        return e;
    }
    @RequestMapping(value = "product/{id}/comments/date", method = RequestMethod.GET)
    public List<Comment> ProductDateComments(@PathVariable("id") String Id,
                                                     @RequestParam("sDate") String StartingDate,
                                                     @RequestParam("eDate") String EndingDate) throws ParseException {
        var startingDate = new SimpleDateFormat("dd-MM-yyyy").parse(StartingDate);
        var endingDate = new SimpleDateFormat("dd-MM-yyyy").parse(EndingDate);
        var e = new ArrayList<Comment>();
        var productComments = productRepository.findById(Id).get().getComments();
        if(productComments.size() > 0){
            for(var obj : productComments){
                if(obj.getDate().after(startingDate) && obj.getDate().before(endingDate))
                    e.add(obj);
            }
            return e;
        }
        return null;
    }

}
