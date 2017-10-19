package com.rosterfile.services;

import com.rosterfile.model.Roster;
import com.rosterfile.repo.RosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jimmy Pena on 8/23/2017.
 */
@Service
public class RosterFileImpl implements RosterFileService {

    @Autowired
    RosterRepository RosterRepository;

    public Roster findOne(String number){
        return RosterRepository.findOne(number);
    }

    public Iterable<Roster> findByZoneId(String zoneId){
        return RosterRepository.findByZoneId(zoneId);

    }

    public Iterable<Roster> findByRegionId(char RegionId){
        return RosterRepository.findByRegionId(RegionId);

    }

    public Iterable<Roster> listAll(){
        return RosterRepository.findAll();
    }

    public Iterable<Roster> findByFullName(String name){
        return RosterRepository.findByFullName('%'+name+'%');
    }

    public Iterable<Roster> findByZRT(String zrt){
        return RosterRepository.findByZRT(zrt+'%');
    }



}
