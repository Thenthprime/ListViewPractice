package edu.psu.swen888.listviewpractice;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        EventListAdapter adapter = new EventListAdapter(ShowAllEvents.this, events);

        mListViewEvents = findViewById(R.id.listview_events);
        mListViewEvents.setAdapter(adapter);
        mListViewEvents.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Event selectedEvent = (Event) parent.getItemAtPosition(position);

                Intent intent = new Intent(ShowAllEvents.this, EventOnClick.class);
                intent.putExtra("selected_event", selectedEvent);
                startActivity(intent);
            }
        });

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
        events.add(new Event("50yd Freestyle", "Individual", 32, "24.25s", "Dana Fischer", 2019 ));        return events;
    }
}
