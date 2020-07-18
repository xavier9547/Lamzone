package com.example.lamzone.ui;


import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lamzone.API.MeetingApiService;
import com.example.lamzone.R;
import com.example.lamzone.model.Room;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CreateMeetingActivity extends AppCompatActivity {

    private List<Room> mRoomList;
    private Room mRoom;
    private MeetingApiService mApiService ;


    @BindView(R.id.spinnerSalle)
    Spinner spinner ;
    @BindView(R.id.btn_back)
    ImageButton btn_back ;
    @BindView(R.id.btn_Time)
    Button btn_hour;
    @BindView(R.id.timeOfMeeting)
    TextView timeOfMeeting;
    @BindView(R.id.btn_date)
    Button btn_date;
    @BindView(R.id.dateOfMeeting)
    TextView dateOfMeeting;
    @BindView(R.id.subject)
    TextInputEditText subject;
    @BindView(R.id.btn_add_meeting)
    Button btn_add_meeting;
    @BindView(R.id.text_add_mail)
    TextInputEditText text_add_mail;
    @BindView(R.id.btn_cancel)
    Button btn_cancel;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_meeting);
        ButterKnife.bind(this);
    }
}