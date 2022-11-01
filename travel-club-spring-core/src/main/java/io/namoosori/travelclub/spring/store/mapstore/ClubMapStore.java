package io.namoosori.travelclub.spring.store.mapstore;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.store.ClubStore;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository("clubStore")
public class ClubMapStore implements ClubStore {

    private Map<String,TravelClub> clubMap;
    public ClubMapStore (){
        this.clubMap = new LinkedHashMap<>();
    }

    @Override
    public String create(TravelClub club) {
        clubMap.put(club.getId(),club);
        return club.getId();//저장되었는지 확인용
    }

    @Override
    public TravelClub retrieve(String clubId) {//
        return clubMap.get(clubId);
    }

    @Override
    public List<TravelClub> retrieveByName(String name) {
        //동일한 이름의 클럽들을 모두 반환하겠다.
        System.out.println(clubMap.values());
        return clubMap.values().stream().filter( club->club.getName().equals(name))//람다식
                .collect(Collectors.toList());
    }

    @Override
    public void update(TravelClub club) {
        clubMap.put(club.getId(),club);
    }

    @Override
    public void delete(String clubId) {
        clubMap.remove(clubId);
    }

    @Override
    public boolean exists(String clubId) {//존재여부 확인
//        clubMap.containsKey(clubId);

        return Optional.ofNullable(clubMap.get(clubId)).isPresent();

    }
}
