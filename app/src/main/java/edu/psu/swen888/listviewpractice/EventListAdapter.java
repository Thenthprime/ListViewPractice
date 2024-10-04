package edu.psu.swen888.listviewpractice;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EventListAdapter extends ArrayAdapter<Event>{
    private Context context;
    private Button detailsButton;



    public EventListAdapter(Context context, ArrayList<Event> events, int image){
        super(context, 0, events);
        this.context = context;
      }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_event, parent, false);
        }

        Event event = getItem(position);
        ImageView itemImage = convertView.findViewById(R.id.event_image);
        TextView textViewTitle = convertView.findViewById(R.id.textview_event_title);
        TextView textViewType = convertView.findViewById(R.id.textview_event_type);

        String eventTitle = "Event: " + String.valueOf(event.getTitle());
        String eventType = "Type: " + String.valueOf(event.getType());

            String type = String.valueOf(event.getType());
            if (type.equals("Individual")) {
                itemImage.setImageResource(R.drawable.baseline_person_24);
            }
            else{
                itemImage.setImageResource(R.drawable.baseline_people_24);
            }


        textViewTitle.setText(eventTitle);
        textViewType.setText(eventType);

        detailsButton = convertView.findViewById(R.id.details_button);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event selectedEvent = getItem(position);
                Intent intent = new Intent(v.getContext(), EventOnClick.class);
                intent.putExtra("selected_event", selectedEvent);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
