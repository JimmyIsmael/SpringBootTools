package com.springsecuritydemo.Repository;



import com.springsecuritydemo.Domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


/**
 * Created by Jimmy Pena on 7/26/2017.
 */

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);



}