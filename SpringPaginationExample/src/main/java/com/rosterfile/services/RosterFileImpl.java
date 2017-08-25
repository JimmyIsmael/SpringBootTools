package com.rosterfile.services;

import com.rosterfile.model.Roster;
import com.rosterfile.repo.SalesRosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jimmy Pena on 8/23/2017.
 */
@Service
public class RosterFileImpl implements RosterFileService {

    @Autowired
    SalesRosterRepository salesRosterRepository;

    public Roster findOne(String number){
        return salesRosterRepository.findOne(number);
    }

    public Iterable<Roster> findByZoneId(String zoneId){
        return salesRosterRepository.findByZoneId(zoneId);

    }

    public Iterable<Roster> findByRegionId(char RegionId){
        return salesRosterRepository.findByRegionId(RegionId);

    }

    public Page<Roster> listAll(Pageable pageable){

        return salesRosterRepository.findAll(pageable);
    }

    public Iterable<Roster> findByFullName(String name){
        return salesRosterRepository.findByFullName('%'+name+'%');
    }

    public Iterable<Roster> findByZRT(String zrt){
        return salesRosterRepository.findByZRT(zrt+'%');
    }



}
