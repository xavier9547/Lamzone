package com.example.lamzone.ui;

import android.content.Intent;
import android.os.Bundle;

import com.example.lamzone.API.MeetingApiService;
import com.example.lamzone.R;
import com.example.lamzone.model.Meeting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingListActivity extends AppCompatActivity {

    private List<Meeting> mMeetings;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mManager;
    private MeetingApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}