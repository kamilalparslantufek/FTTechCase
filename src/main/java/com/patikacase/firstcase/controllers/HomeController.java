package com.patikacase.firstcase.controllers;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.patikacase.firstcase.models.Product;
import com.patikacase.firstcase.models.User;
import com.patikacase.firstcase.models.Comment;
import com.patikacase.firstcase.models.UserProductList;
import com.patikacase.firstcase.models.UserProductListModel;
import com.patikacase.firstcase.repository.CommentRepository;
import com.patikacase.firstcase.repository.ProductRepository;
import com.patikacase.firstcase.repository.UserRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class HomeController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
 // @Autowired
//  private CommentRepository commentRepository;
 /* @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public Object InsertProduct() throws ParseException {
        //var product = new Product(UUID.randomUUID().toString(),"P2",23.2);
        //var product = new User(UUID.randomUUID().toString(),"u1","u1s","u1s@asd","2151512");
        var product = new Comment(UUID.randomUUID().toString(),new SimpleDateFormat("dd-MM-yyyy").parse("12-09-2022"),"c1","6cb5a389-27e2-4029-80c9-fbe32d6ddc70","c5102b18-d1e0-4959-bdb8-563cc6b1be34");
        commentRepository.save(product);
        return product;
    }*/


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public UserProductList Index(){
         ArrayList<UserProductListModel> users = new ArrayList<UserProductListModel>();
         ArrayList<UserProductListModel> products = new ArrayList<UserProductListModel>();
        for (User user : userRepository.findAll()) {
            users.add(new UserProductListModel(user.getId(), user.getName()));
        }
        for (Product product : productRepository.findAll()) {
            products.add(new UserProductListModel(product.getId(),product.getName()));
        }
        return new UserProductList(users,products);
    }

}
