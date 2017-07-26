package com.springjpa.repo;

import com.springjpa.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
