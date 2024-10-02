package edu.psu.swen888.listviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EventListAdapter extends ArrayAdapter<Event>{
    public EventListAdapter(Context context, ArrayList<Event> events){
        super(context, 0, events);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_event, parent, false);
        }

        Event event = getItem(position);

        TextView textViewTitle = convertView.findViewById(R.id.textview_event_title);
        TextView textViewType = convertView.findViewById(R.id.textview_event_type);

        String eventTitle = "Event: " + String.valueOf(event.getTitle());
        String eventType = "Type: " + String.valueOf(event.getType());


        textViewTitle.setText(eventTitle);
        textViewType.setText(eventType);

        return convertView;
    }
}
