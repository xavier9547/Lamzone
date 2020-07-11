package com.example.lamzone.API;

import com.example.lamzone.model.Meeting;
import com.example.lamzone.model.Room;

import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {
    private List<Room> mRooms = RoomGenerator.generateRooms();

    private List <Meeting> meetings =  Database.generateMeetings();

    @Override
    public List<Room> getRooms() {
        return mRooms;
    }

    @Override
    public List<Meeting> getMeetingsList() {
        return meetings;
    }

    @Override
    public void deleteMeeting(Meeting meeting) {

        meetings.remove(meeting);

    }

    @Override
    public void addMeeting(Meeting meeting) {

        meetings.add(meeting);
    }
}



