package edu.psu.swen888.listviewpractice;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class EventOnClick extends AppCompatActivity {
    private TextView mTextViewTitle;
    private TextView mTextViewType;
    private TextView mTextViewNumberOfTeams;
    private TextView mTextViewCurrentRecord;
    private TextView mTextViewCurrentRecordHolder;
    private TextView mTextViewCurrentRecordYear;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_on_click);

        Event selectedEvent = (Event) getIntent().getSerializableExtra("selected_event");

        mTextViewTitle = findViewById(R.id.textview_title);
        mTextViewType = findViewById(R.id.textview_type);
        mTextViewNumberOfTeams = findViewById(R.id.textview_numberOfTeams);
        mTextViewCurrentRecord = findViewById(R.id.textview_currentRecord);
        mTextViewCurrentRecordHolder = findViewById(R.id.textview_currentRecordHolder);
        mTextViewCurrentRecordYear = findViewById(R.id.textview_currentRecordYear);

        String eventTitle = "Event: " + String.valueOf(selectedEvent.getTitle());
        String eventType = "Type: " + String.valueOf(selectedEvent.getType());
        String eventNumberOfTeams = "Number of Trials: " + String.valueOf(selectedEvent.getNumberOfTeams());
        String eventCurrentRecord = "Current Record: " + String.valueOf(selectedEvent.getCurrentRecord());
        String eventCurrentRecordHolder = "Current Record Holder: " + String.valueOf(selectedEvent.getCurrentRecordHolder());
        String eventCurrentRecordYear = "Current Record Year: " + String.valueOf(selectedEvent.getCurrentRecordYear());

        mTextViewTitle.setText(eventTitle);
        mTextViewType.setText(eventType);
        mTextViewNumberOfTeams.setText(eventNumberOfTeams);
        mTextViewCurrentRecord.setText(eventCurrentRecord);
        mTextViewCurrentRecordHolder.setText(eventCurrentRecordHolder);
        mTextViewCurrentRecordYear.setText(eventCurrentRecordYear);

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
                Toast.makeText(EventOnClick.this, ("Returning to All Events List."), Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
