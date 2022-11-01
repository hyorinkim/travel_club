package io.namoosori.travelclub.spring;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TravelClubApp {
    public static void main(String[] args) {
        //프로그램 시작되면 entry point가 된다.
        //applicationContext.xml 정보를 spring한테 알려줘야하니까 넘겨주는 코드가 있어야한다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext 클래스타입임
        //spring 프레임워크에게 같은 ContextPath 안에 applicationContext.xml안에 있다라고 알려주는 코드
        //JavaClass를 이용하는 방법도 있음

        String [] beanNames =context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames));

        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub","Test TravelClub");
        ClubService clubService = context.getBean("clubService",ClubService.class);
        String clubId=clubService.registerClub(clubCdo);

        System.out.println("ID "+clubId);
    }
}
