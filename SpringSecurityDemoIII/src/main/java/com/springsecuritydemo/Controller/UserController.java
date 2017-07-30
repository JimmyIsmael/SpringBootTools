package com.springsecuritydemo.Controller;


import com.springsecuritydemo.Domain.User;
import com.springsecuritydemo.Repository.RoleRepository;
import com.springsecuritydemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/SaveUser")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userType",roleRepository.findAll());
        return "SaveUser";
    }

    @PostMapping("/SaveUser")
    public String userSubmit(@ModelAttribute User user, Model model) {

        // calcular el HASH de la contraseña
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);

        userRepository.save(user);
        model.addAttribute("user", userRepository.findAll());
        return "ShowUsers";
    }

    @GetMapping("ShowUsers")
    public String showAllUsers(Model model) {
        model.addAttribute("user", userRepository.findAll());
        return "ShowUsers";
    }

    @RequestMapping("/SaveUser/edit/{id}")
    public String editUser(@PathVariable Long id, Model model){
        Optional<User> user=userRepository.findById(id);
        user.toString();
        model.addAttribute("user", user);

        model.addAttribute("userType",roleRepository.findAll());
        return "SaveUser";
    }

    @RequestMapping("/ShowUsers/search/{name}")
    public String searchUser(@PathVariable String name, Model model){
            model.addAttribute("user", userRepository.findByEmail(name));
            System.out.println(userRepository.toString());
            return "ShowUsers";
    }

    @RequestMapping("/SaveUser/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model){
        userRepository.deleteById(id);
        showAllUsers(model);
        return "ShowUsers";
    }

}
