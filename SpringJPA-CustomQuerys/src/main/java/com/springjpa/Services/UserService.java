package com.springjpa.Services;

import com.springjpa.model.User;
import org.springframework.data.repository.query.Param;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
public interface UserService {
    Iterable<User> listAllUsers();

    User getUserById(Long id);

    User saveUser(User user);

    void deleteUser(Long user);

    Iterable<User> getUsersByFirstName(@Param("parameter") String parameter);

    Iterable<User> getUsersByLastName(@Param("parameter") String parameter);
}
