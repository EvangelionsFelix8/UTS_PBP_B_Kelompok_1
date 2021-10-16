package com.example.uts_pbp_b_kelompok_1.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp_b_kelompok_1.Event;
import com.example.uts_pbp_b_kelompok_1.databinding.RvEventBinding;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.viewHolder> {

    List<Event> listEvent;

    public EventAdapter(ArrayList<Event> listEvent) {
        this.listEvent = listEvent;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private RvEventBinding binding;
        public viewHolder(@NonNull RvEventBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RvEventBinding binding = RvEventBinding.inflate(inflater, parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Event event = listEvent.get(position);
        holder.binding.setEvent(event);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return listEvent.size();
    }
}
