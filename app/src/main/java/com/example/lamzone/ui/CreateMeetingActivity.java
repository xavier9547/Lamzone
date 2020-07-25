package com.example.lamzone.ui;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lamzone.API.MeetingApiService;
import com.example.lamzone.R;
import com.example.lamzone.di.DI;
import com.example.lamzone.model.Meeting;
import com.example.lamzone.model.Room;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CreateMeetingActivity extends AppCompatActivity {

    private List<Room> mRoomList;
    private Room mRoom;
    private MeetingApiService mApiService ;
    private AdapterSpinner mAdapterSpinner;

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

        mApiService= DI.getMeetingApiService();
        mRoomList = DI.getMeetingApiService().getRooms();

        mAdapterSpinner = new AdapterSpinner(this, mRoomList);
        spinner.setAdapter(mAdapterSpinner);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                mRoom = (Room) adapterView.getItemAtPosition(i);
                mRoom = (Room) spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_back.setOnClickListener(view -> startActivity(new Intent(CreateMeetingActivity.this, MeetingListActivity.class)));

        btn_date.setOnClickListener(view -> dateHandle());

        btn_hour.setOnClickListener(view -> timeHandle());



        btn_add_meeting.setOnClickListener(view -> {

            if (subject.getText().toString().isEmpty() && text_add_mail.getText().toString().isEmpty()) {

                Toast.makeText(getApplicationContext(),"Subject et Email Champs Obligatoir " , Toast.LENGTH_LONG).show();
            }


            else {
                Meeting meeting = new Meeting(
                        subject.getText().toString(),
                        mRoom,
                        timeOfMeeting.getText().toString(),
                        dateOfMeeting.getText().toString(),
                        text_add_mail.getText().toString()
                );
                mApiService.addMeeting(meeting);
                Intent intent = new Intent(CreateMeetingActivity.this, MeetingListActivity.class);
                startActivity(intent);
            }
        });

        btn_cancel.setOnClickListener(view -> {

            subject.setText("");
            timeOfMeeting.setText("");
            dateOfMeeting.setText("");
            text_add_mail.setText("");

        });

    }

    public void dateHandle() {

        final Calendar calendar = Calendar.getInstance();

        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(CreateMeetingActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                String dateString = year + " " + month + " " + " " + date;
                dateOfMeeting.setText(dateString);

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);

                CharSequence dateTexte = DateFormat.format("MMM d , yyyy", calendar1);

                dateOfMeeting.setText(dateTexte);
            }
        }, YEAR, MONTH, DATE);

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();

    }

    public void timeHandle(){

        final Calendar calendar1 = Calendar.getInstance();

        int HOUR = calendar1.get(Calendar.HOUR_OF_DAY);
        int MINUTE = calendar1.get(Calendar.MINUTE);

        boolean is24hourFormat = DateFormat.is24HourFormat(this);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, (timePicker, hour, minute) -> {

            String timeString = hour +" "+ minute;
            timeOfMeeting.setText(timeString);

            Calendar calendar11 = Calendar.getInstance();
            calendar11.set(Calendar.HOUR,hour);
            calendar11.set(Calendar.MINUTE,minute);

            CharSequence timeText = DateFormat.format("hh:mm a", calendar11);

            timeOfMeeting.setText(timeText);

        },HOUR,MINUTE,is24hourFormat);

        timePickerDialog.show();

    }

}