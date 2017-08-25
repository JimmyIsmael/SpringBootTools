package com.rosterfile.services;

import com.rosterfile.model.Roster;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Jimmy Pena on 8/23/2017.
 */

public interface RosterFileService {

    Roster findOne(String number);

    Page<Roster> listAll(Pageable pageable);

    Iterable<Roster> findByZoneId(@Param("zoneId") String zoneId);

    Iterable<Roster> findByRegionId(@Param("RegionId") char RegionId);

    Iterable<Roster> findByFullName(@Param("name") String name);

    Iterable<Roster> findByZRT(@Param("zrt") String zrt);


}
