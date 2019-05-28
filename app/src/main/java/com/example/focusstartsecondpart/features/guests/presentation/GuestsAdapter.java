package com.example.focusstartsecondpart.features.guests.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focusstartsecondpart.R;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.ArrayList;
import java.util.List;

public class GuestsAdapter extends RecyclerView.Adapter<GuestsAdapter.GuestsHolder> {

    private final List<Guest> guests = new ArrayList<>();
    private final LayoutInflater layoutInflater;
    private final GuestsAdapter.SelectGuestListener selectGuestListener;

    public GuestsAdapter(Context context, GuestsAdapter.SelectGuestListener selectGuestListener){
        layoutInflater = LayoutInflater.from(context);
        this.selectGuestListener = selectGuestListener;
    }


    @NonNull
    @Override
    public GuestsAdapter.GuestsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = layoutInflater.inflate(R.layout.guest_item, parent, false);

        return new GuestsAdapter.GuestsHolder(itemView, selectGuestListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestsAdapter.GuestsHolder holder, int position) {
        holder.bind(guests.get(position));
    }

    @Override
    public int getItemCount() {
        return guests.size();
    }

    public void setGuests(List<Guest> guestList) {
        guests.clear();
        guests.addAll(guestList);
        notifyDataSetChanged();
    }


    class GuestsHolder extends RecyclerView.ViewHolder {

        private final TextView guestNameView;
        private final TextView guestTextView;
        private final GuestsAdapter.SelectGuestListener selectGuestListener;

        public GuestsHolder(@NonNull View itemView, GuestsAdapter.SelectGuestListener selectGuestListener) {
            super(itemView);
            this.selectGuestListener = selectGuestListener;
            guestNameView = itemView.findViewById(R.id.guest_item_name);
            guestTextView = itemView.findViewById(R.id.guest_item_text);
        }

        void bind(final Guest guest) {
            guestNameView.setText(guest.getFirstName());
            guestTextView.setText(guest.getLastName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectGuestListener.onGuestSelect(guest);
                }
            });
        }
    }


    interface SelectGuestListener {

        void onGuestSelect(Guest guest);

    }
}
