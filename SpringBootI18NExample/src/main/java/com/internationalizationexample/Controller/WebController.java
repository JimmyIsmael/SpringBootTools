package com.internationalizationexample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by jpena on 3/14/2018.
 */

@Controller
public class WebController {
    @Autowired
    LocaleResolver localeResolver;

    Locale espanol = new Locale("es_DO");
    Locale ingles = new Locale("en_US" );

    @RequestMapping("/es")
    public String indexPageES(Model model, HttpServletRequest request){
        localeResolver.setLocale(request,null,espanol);
        return "index";
    }

    @RequestMapping("/en")
    public String indexPageEN(Model model, HttpServletRequest request){
        localeResolver.setLocale(request,null,ingles);
        return "index";
    }
}
