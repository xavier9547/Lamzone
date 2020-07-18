package com.example.lamzone.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lamzone.R;
import com.example.lamzone.event.DeleteMeeting;
import com.example.lamzone.model.Meeting;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


    public class AdapterList extends RecyclerView.Adapter <AdapterList.ViewHolder> {
        List<Meeting> mMeeting;

        public AdapterList(List<Meeting> mMeeting) {
            this.mMeeting = mMeeting;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.imageRoom)
            ImageView imageRoom;
            @BindView(R.id.subject)
            TextView subjectMeeting;
            @BindView(R.id.hour)
            TextView hourMeeting;
            @BindView(R.id.date)
            TextView date;
            @BindView(R.id.Room_Name)
            TextView nameRoom;
            @BindView(R.id.btnDelete)
            ImageButton btnDelete;
            @BindView(R.id.text_email)
            TextView mEmail;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Meeting meeting = mMeeting.get(position);

            holder.subjectMeeting.setText(meeting.getmSubject());
            holder.hourMeeting.setText(meeting.getmHour());
            holder.nameRoom.setText(meeting.getmRoom().getmNameRoom());
            holder.date.setText(meeting.getmDate());
            holder.mEmail.setText(meeting.getmEmails());
            Glide.with(holder.imageRoom.getContext())
                    .load(meeting.getmRoom().getmRoomColor())
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.imageRoom);

            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    EventBus.getDefault().post(new DeleteMeeting(meeting));
                }
            });

        }

        @Override
        public int getItemCount() {
            return mMeeting.size();
        }
    }