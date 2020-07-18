package com.example.lamzone.API;

import com.example.lamzone.R;
import com.example.lamzone.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomGenerator {public static List<Room> LIST_ROOM = Arrays.asList(

        new Room("Salle 1" , R.drawable.ic_room1_foreground ),
        new Room("Salle 2" , R.drawable.ic_room1_foreground ),
        new Room("Salle 3" , R.drawable.ic_room1_foreground ),
        new Room("Salle 4" , R.drawable.ic_room1_foreground ),
        new Room("Salle 5" , R.drawable.ic_room1_foreground ),
        new Room("Salle 6" , R.drawable.ic_room1_foreground ),
        new Room("Salle 7" , R.drawable.ic_room1_foreground ),
        new Room("Salle 8" , R.drawable.ic_room1_foreground ),
        new Room("Salle 9" , R.drawable.ic_room1_foreground ),
        new Room("Salle 10" , R.drawable.ic_room1_foreground)

);

    public static List<Room> generateRooms() {
        return new ArrayList<>(LIST_ROOM);
    }
}

