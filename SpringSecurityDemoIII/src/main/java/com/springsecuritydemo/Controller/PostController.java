package com.springsecuritydemo.Controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jimmy Pena on 7/26/2017.
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    @Secured("ROLE_GUEST")
    @RequestMapping("/list")
    public String list(){
        return "List all posts";
    }

    @Secured("ROLE_USER")
    @RequestMapping("/draft")
    public String draft(){
        return "Draft";
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping("/add")
    public String add(){
        return "Add a post";
    }

}
