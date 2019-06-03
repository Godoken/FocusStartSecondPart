package com.example.focusstartsecondpart.features.events.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focusstartsecondpart.R;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.ArrayList;
import java.util.List;


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsHolder> {

    private final List<Event> events = new ArrayList<>();
    private final LayoutInflater layoutInflater;
    private final SelectEventListener selectEventListener;

    public EventsAdapter(Context context, SelectEventListener selectEventListener){
        layoutInflater = LayoutInflater.from(context);
        this.selectEventListener = selectEventListener;
    }

    @NonNull
    @Override
    public EventsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = layoutInflater.inflate(R.layout.event_item, parent, false);
        return new EventsHolder(itemView, selectEventListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsHolder holder, int position) {
        holder.bind(events.get(position));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void setEvents(List<Event> eventList) {
        events.clear();
        events.addAll(eventList);
        notifyDataSetChanged();
    }

    class EventsHolder extends RecyclerView.ViewHolder {

        private final TextView eventNameView;
        private final TextView eventTextView;
        private final SelectEventListener selectEventListener;

        public EventsHolder(@NonNull View itemView, SelectEventListener selectEventListener) {
            super(itemView);
            this.selectEventListener = selectEventListener;
            eventNameView = itemView.findViewById(R.id.event_item_name);
            eventTextView = itemView.findViewById(R.id.event_item_text);
        }

        void bind(final Event event) {
            eventNameView.setText(event.getTitle());
            eventTextView.setText(event.getDescription());

            itemView.setOnClickListener(v -> selectEventListener.onEventSelect(event));
        }
    }

    interface SelectEventListener {
        void onEventSelect(Event event);
    }
}
