package com.example.lamzone.event;

import android.util.Log;

import com.example.lamzone.model.Meeting;

public class DeleteMeeting {

    public Meeting meeting ;

    public DeleteMeetingEvent(Meeting meeting) {
        Log.d("DEBUG", "DeleteMeetingEvent: Delete Meeting from meetings list");

        this.meeting = meeting;
    }
}

