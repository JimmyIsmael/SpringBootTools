package com.springjpa.controller;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;
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
public class SavingController {
    @Autowired
    CustomerRepository repository;

    @GetMapping("/saving")
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "saving";
    }

    @PostMapping("/saving")
    public String customerSubmit(@ModelAttribute Customer customer) {
        System.out.println(customer);
        repository.save(customer);
        return "saving";
    }

}
