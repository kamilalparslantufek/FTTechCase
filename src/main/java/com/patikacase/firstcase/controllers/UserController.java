package com.patikacase.firstcase.controllers;

import com.patikacase.firstcase.models.Comment;
import com.patikacase.firstcase.models.Product;
import com.patikacase.firstcase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user/{id}/comments")
    public  ResponseEntity<List<Comment>> UserComments(@PathVariable("id") String UserId){
        var res = userRepository.findById(UserId).get().getComments();
        if (res.size() > 0)
            return new ResponseEntity<>(userRepository.findById(UserId).get().getComments(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("user/{id}/comments/date")
    public ResponseEntity<ArrayList<Comment>> UserDateComments(@PathVariable("id") String Id,
                                                            @RequestParam("sDate") String StartingDate,
                                                            @RequestParam("eDate") String EndingDate) throws ParseException {
        var startingDate = new SimpleDateFormat("dd-MM-yyyy").parse(StartingDate);
        var endingDate = new SimpleDateFormat("dd-MM-yyyy").parse(EndingDate);
        var e = new ArrayList<Comment>();
        var userComments = userRepository.findById(Id).get().getComments();
        if(userComments.size() > 0){
            for(var obj : userComments){
                if(obj.getDate().after(startingDate) && obj.getDate().before(endingDate))
                    e.add(obj);
            }
            return new ResponseEntity<>(e, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
