package io.namoosori.travelclub.spring.service.logic;

import io.namoosori.travelclub.spring.TravelClubApp;
import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;
import io.namoosori.travelclub.spring.store.ClubStore;
import io.namoosori.travelclub.spring.util.exception.NoSuchClubException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("clubService")// bean의 id (이름)를 주고 싶을 때
//DI를 주는 방법은 여러가지가 있음
public class ClubServiceLogic implements ClubService {
    private ClubStore clubStore;
    public ClubServiceLogic(ClubStore clubStore){
        this.clubStore=clubStore;
    }
    @Override
    public String registerClub(TravelClubCdo club) {
        TravelClub newClub = new TravelClub(club.getName(),club.getIntro());
        newClub.checkValidation();
        return clubStore.create(newClub);
    }

    @Override
    public TravelClub findClubById(String id) {
        return clubStore.retrieve(id);
    }

    @Override
    public List<TravelClub> findClubsByName(String name) {
        return clubStore.retrieveByName(name);
    }

    @Override
    public void modify(String clubId, NameValueList nameValues) {
    TravelClub foundedClub = clubStore.retrieve(clubId);
    if(foundedClub==null){
        throw new NoSuchClubException("No such club with id: "+clubId);
    }
    foundedClub.modifyValues(nameValues);
    clubStore.update(foundedClub);
    }

    @Override
    public void remove(String clubId) {
        if(!clubStore.exists(clubId)){
            throw new NoSuchClubException("No such club with id: "+clubId);
        }
        clubStore.delete(clubId);
    }
}
