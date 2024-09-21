package edu.psu.swen888.listviewpractice;

import static android.content.Intent.*;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //layout according to the xml file
        setContentView(R.layout.main_activity);
    }
    public void onShowAllEventsButtonClicked(View view){
        String name = "Hello Java";
        int mData = 25;


        Intent intent = new Intent(MainActivity.this, ShowAllEvents.class);
        intent.putExtra("text", name);
        intent.putExtra("data", mData);

        startActivity(intent);
    }
}