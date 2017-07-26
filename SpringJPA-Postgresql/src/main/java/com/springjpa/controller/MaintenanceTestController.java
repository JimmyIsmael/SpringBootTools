package com.springjpa.controller;

import com.springjpa.model.MaintenanceTest;
import com.springjpa.repo.MaintenanceTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
@Controller
public class MaintenanceTestController {
    @Autowired
    MaintenanceTestRepository repository;

    @GetMapping("/MaintenanceTest")
    public String customerForm(Model model) {
        model.addAttribute("maintenanceTest", new MaintenanceTest());
        return "MaintenanceTest";
    }

    @PostMapping("/MaintenanceTest")
    public String customerSubmit(@ModelAttribute MaintenanceTest maintenanceTest) {
        System.out.println(maintenanceTest);
        repository.save(maintenanceTest);
        return "MaintenanceTest";
    }
}
