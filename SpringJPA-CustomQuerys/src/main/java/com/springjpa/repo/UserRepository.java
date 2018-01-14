package com.springjpa.repo;

import com.springjpa.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
public interface UserRepository extends CrudRepository<User,Long> {

    //Example for an static custom query
    @Query("select u from User u where lower(u.apellido) LIKE lower(?1)")
    Iterable<User> getUsersByLastName(@Param("parameter") String parameter);
}
