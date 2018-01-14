package com.springjpa.Services;

import com.springjpa.model.User;
import com.springjpa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

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

    @Override
    //Example of a query that can be build on execution time
    public Iterable<User> getUsersByFirstName(@Param("parameter") String parameter){
        String sql="select u from User u where lower(u.nombre) LIKE lower(?1)";
        TypedQuery query=entityManager.createQuery(sql,User.class);
        query.setParameter(1,'%'+parameter+'%');

        return query.getResultList();
    }

    @Override
    public Iterable<User> getUsersByLastName(@Param("parameter") String parameter){
      return  userRepository.getUsersByLastName(parameter);
    }
}
