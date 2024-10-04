package edu.psu.swen888.listviewpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //layout according to the xml file
        setContentView(R.layout.main_activity);
    }

    //add functionality to the back menu bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //use an intent to go from main activity into the all events listview
    public void onShowAllEventsClicked(View view){
        Intent intent = new Intent(MainActivity.this, ShowAllEvents.class);
        startActivity(intent);
    }
}