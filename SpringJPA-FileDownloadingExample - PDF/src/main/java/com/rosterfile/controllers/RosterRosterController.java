package com.rosterfile.controllers;

import com.rosterfile.model.Roster;
import com.rosterfile.services.RosterFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RosterRosterController {

    @Autowired
    RosterFileService rosterFileService;

    @RequestMapping("/")
    public String loadData(Model model) {
        Iterable<Roster> roster=rosterFileService.listAll();
        model.addAttribute("roster",roster);
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