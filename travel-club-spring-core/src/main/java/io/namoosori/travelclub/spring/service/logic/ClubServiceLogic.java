package io.namoosori.travelclub.spring.service.logic;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;

import java.util.List;

public class ClubServiceLogic implements ClubService {
    @Override
    public String registerClub(TravelClubCdo club) {
        return null;
    }

    @Override
    public TravelClub findClubById(String id) {
        return null;
    }

    @Override
    public List<TravelClub> findClubsByName(String name) {
        return null;
    }

    @Override
    public void modify(String clubId, NameValueList nameValues) {

    }

    @Override
    public void remove(String clubId) {

    }
}
