package io.namoosori.travelclub.spring.service.logic;

import io.namoosori.travelclub.spring.TravelClubApp;
import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;
import io.namoosori.travelclub.spring.store.ClubStore;
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
