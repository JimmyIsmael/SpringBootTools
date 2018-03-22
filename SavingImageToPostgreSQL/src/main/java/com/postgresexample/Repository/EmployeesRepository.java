package com.postgresexample.Repository;

import com.postgresexample.Model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by jpena on 3/19/2018.
 */
public interface EmployeesRepository extends CrudRepository<Employee,Integer> {
    Employee save(Employee employee);

    Iterable<Employee> findAll();

    @Query("select e from Employee e where e.id=:id")
    Employee findOne(@Param("id") Integer id);
}
