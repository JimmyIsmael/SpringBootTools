package com.springsecuritydemo.Repository;


import com.springsecuritydemo.Domain.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jimmy Pena on 7/24/2017.
 */
public interface RoleRepository extends CrudRepository<Role,Long> {
}
