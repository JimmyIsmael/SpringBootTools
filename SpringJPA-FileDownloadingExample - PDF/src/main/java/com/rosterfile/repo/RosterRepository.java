package com.rosterfile.repo;

import com.rosterfile.model.Roster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Jimmy Pena on 8/23/2017.
 */
public interface RosterRepository extends JpaRepository<Roster,String> {


    @Query("select r from com.rosterfile.model.Roster r where r.ZRT=?1")
    Roster findOne(String number);

    @Query("select r from com.rosterfile.model.Roster r order by r.ZRT")
    Iterable<Roster> listAll();

    @Query("select r from com.rosterfile.model.Roster r where r.ZONE=:zoneId")
    Iterable<Roster> findByZoneId(@Param("zoneId") String zoneId);

    @Query("select r from com.rosterfile.model.Roster r where r.REGION=:RegionId")
    Iterable<Roster> findByRegionId(@Param("RegionId") char RegionId);

    @Query("select r from com.rosterfile.model.Roster r where r.FULL_NAME like :name")
    Iterable<Roster> findByFullName(@Param("name") String name);

    @Query("select r from com.rosterfile.model.Roster r where r.ZRT like :zrt order by r.ZRT")
    Iterable<Roster> findByZRT(@Param("zrt") String zrt);

}
