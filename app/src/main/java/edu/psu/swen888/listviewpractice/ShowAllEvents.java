package edu.psu.swen888.listviewpractice;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowAllEvents extends AppCompatActivity {
    private ListView mListViewEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_events);

        ArrayList<Event> events = loadEventData();
        int image;
        for(Event event : events){
            String type = String.valueOf(event.getType());
            if (type.equals("Individual")) {
                image = R.drawable.baseline_person_24;
            }
            else{
                image = R.drawable.baseline_people_24;
            }
            EventListAdapter adapter = new EventListAdapter(ShowAllEvents.this, events, image);
            mListViewEvents = findViewById(R.id.listview_events);
            mListViewEvents.setAdapter(adapter);
        }

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Event> loadEventData(){
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("50yd Freestyle", "Individual", 32, "24.25", "Dana Fischer", 2019 ));
        events.add(new Event("400yd Freestyle", "Relay", 10, "3:42.42", "Southside High School", 2021 ));
        events.add(new Event("50yd Backstroke", "Individual", 25, "25.42", "Maximus Lander", 2015 ));
        events.add(new Event("100yd Butterfly", "Individual", 18, "47.14s", "Jordan Knight", 2008 ));
        events.add(new Event("200yd Medley", "Relay", 12, "1:48.10s", "Riverdale High School", 2023 ));
        return events;
    }
}
