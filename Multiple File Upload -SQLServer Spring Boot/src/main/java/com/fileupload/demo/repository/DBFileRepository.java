package com.fileupload.demo.repository;

import com.fileupload.demo.model.DBFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DBFileRepository extends CrudRepository<DBFile, Integer> {

    @Override
    Optional<DBFile> findById(Integer id);

    @Override
    DBFile save(DBFile file);
}
