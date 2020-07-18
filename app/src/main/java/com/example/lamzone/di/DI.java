package com.example.lamzone.di;

import com.example.lamzone.API.DummyMeetingApiService;
import com.example.lamzone.API.MeetingApiService;

public class DI {
    private static MeetingApiService service =  new DummyMeetingApiService();


    public static MeetingApiService getMeetingApiService() {
        return service;
    }


    public static MeetingApiService getNewInstanceApiService() {

        return new DummyMeetingApiService();
    }
}
