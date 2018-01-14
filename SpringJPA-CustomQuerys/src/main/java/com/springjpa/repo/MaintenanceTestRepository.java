package com.springjpa.repo;

import org.springframework.data.repository.CrudRepository;
import com.springjpa.model.MaintenanceTest;

import java.util.List;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
public interface MaintenanceTestRepository extends CrudRepository<MaintenanceTest,Long> {
    List<MaintenanceTest> findBydescripcion(String descripcion);
}
