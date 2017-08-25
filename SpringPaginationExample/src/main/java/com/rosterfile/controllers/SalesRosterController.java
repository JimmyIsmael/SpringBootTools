package com.rosterfile.controllers;

import com.rosterfile.model.Roster;
import com.rosterfile.services.RosterFileService;
import com.rosterfile.utils.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SalesRosterController {

    @Autowired
    RosterFileService rosterFileService;

    @RequestMapping("/")
    public String loadData(Model model,
                           @RequestParam(defaultValue="1", value="page.page", required=false) Integer start,
                           @RequestParam(defaultValue="8", value="page.size", required=false) Integer size) {

        PageWrapper<Roster> page = new PageWrapper<Roster>(
                rosterFileService.listAll(new PageRequest(start-1, size, Sort.Direction.ASC, "ZRT")), "/");
        
        //"ZRT" is the field what it sorts by.
        //"/" is the view that calls the method.

        //Iterable<Roster> roster=rosterFileService.listAll();
        model.addAttribute("page",page);
        return "roster/index";
    }

    @RequestMapping("/profile/{zrt}")
    public String loadProfile(@PathVariable String zrt, Model model){
        Roster profile=rosterFileService.findOne(zrt);
        model.addAttribute("profile", profile);

        return "roster/profile";
    }

    @RequestMapping("/searchByName/{name}")
    public String searchByName(@PathVariable String name, Model model){
        Iterable<Roster> roster=rosterFileService.findByFullName(name);
        model.addAttribute("roster", roster);

        return "roster/index";
    }

    @RequestMapping("/searchByZRT/{zrt}")
    public String searchByZRT(@PathVariable String zrt, Model model){
        Iterable<Roster> roster=rosterFileService.findByZRT(zrt);
        model.addAttribute("roster", roster);

        return "roster/index";
    }

}
