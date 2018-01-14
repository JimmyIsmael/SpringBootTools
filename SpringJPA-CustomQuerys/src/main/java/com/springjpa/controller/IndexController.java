package com.springjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JimmyIsmael on 11/17/2016.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String home(){
        return "index";
    }
}
