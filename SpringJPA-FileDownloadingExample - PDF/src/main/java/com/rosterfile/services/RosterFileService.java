<<<<<<< HEAD
package com.rosterfile.services;

import com.rosterfile.model.Roster;
import org.springframework.data.repository.query.Param;

/**
 * Created by Jimmy Pena on 8/23/2017.
 */

public interface RosterFileService {

    Roster findOne(String number);

    Iterable<Roster> listAll();

    Iterable<Roster> findByZoneId(@Param("zoneId") String zoneId);

    Iterable<Roster> findByRegionId(@Param("RegionId") char RegionId);

    Iterable<Roster> findByFullName(@Param("name") String name);

    Iterable<Roster> findByZRT(@Param("zrt") String zrt);


}
=======
package com.rosterfile.services;

import com.rosterfile.model.Roster;
import org.springframework.data.repository.query.Param;

/**
 * Created by Jimmy Pena on 8/23/2017.
 */

public interface RosterFileService {

    Roster findOne(String number);

    Iterable<Roster> listAll();

    Iterable<Roster> findByZoneId(@Param("zoneId") String zoneId);

    Iterable<Roster> findByRegionId(@Param("RegionId") char RegionId);

    Iterable<Roster> findByFullName(@Param("name") String name);

    Iterable<Roster> findByZRT(@Param("zrt") String zrt);


}
>>>>>>> a7a8243b01ff76dbde78931f5f258da59e145777
