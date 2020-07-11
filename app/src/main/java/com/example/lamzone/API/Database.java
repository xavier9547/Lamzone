package com.example.lamzone.API;

import com.example.lamzone.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {public static List<Meeting> meetingList = Arrays.asList(

        new Meeting("Reunion1", RoomGenerator.generateRooms().get(0), "10:00 AM", "Nov 12,2020", " olivier@lamzone.com,paul@lamzone.com"),
        new Meeting("Reunion2", RoomGenerator.generateRooms().get(1), "03:00 PM","Jan 13,2020",  "katy@lamzone.com,paul@lamzone.com"),
        new Meeting("Reunion3", RoomGenerator.generateRooms().get(2), "04:00 PM", "Mar 14,2020", "katy@lamzone.com,paul@lamzone.com")
);

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(meetingList);
    }
}


