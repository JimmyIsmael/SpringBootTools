package com.springjpa.Services;

import com.springjpa.model.User;
import com.springjpa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> listAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id){
        return userRepository.findOne(id);
    }


    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id){
        userRepository.delete(id);
    }
}
