package com.example.lamzone.API;

import com.example.lamzone.model.Meeting;
import com.example.lamzone.model.Room;

import java.util.List;

public interface MeetingApiService {
    List<Room> getRooms ();

    List<Meeting> getMeetingsList() ;


    void deleteMeeting(Meeting meeting);

    void addMeeting(Meeting meeting);

}
