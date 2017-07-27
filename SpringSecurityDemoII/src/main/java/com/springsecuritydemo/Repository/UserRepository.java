package com.springsecuritydemo.Repository;



import com.springsecuritydemo.Domain.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by Jimmy Pena on 7/26/2017.
 */

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}