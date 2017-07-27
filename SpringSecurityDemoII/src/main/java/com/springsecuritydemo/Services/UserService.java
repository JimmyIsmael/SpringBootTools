package com.springsecuritydemo.Services;

import com.springsecuritydemo.Domain.User;

/**
 * Created by Jimmy Pena on 7/26/2017.
 */

public interface UserService {

    public User findByEmail(String email);

}