package com.example.uts_pbp_b_kelompok_1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp_b_kelompok_1.DetailEventActivity;
import com.example.uts_pbp_b_kelompok_1.Event;
import com.example.uts_pbp_b_kelompok_1.R;
import com.example.uts_pbp_b_kelompok_1.databinding.RvEventBinding;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.viewHolder> {
    private Context context;
    List<Event> listEvent;

    public EventAdapter(Context context, ArrayList<Event> listEvent) {
        this.context= context;
        this.listEvent = listEvent;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private RvEventBinding binding;
        ImageButton btnDetail;
        public viewHolder(@NonNull RvEventBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            btnDetail = itemView.findViewById(R.id.btnDetail);
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RvEventBinding binding = RvEventBinding.inflate(inflater, parent, false);
        return new viewHolder( binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Event event = listEvent.get(position);
        holder.binding.setEvent(event);
        holder.binding.executePendingBindings();
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,DetailEventActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listEvent.size();
    }
}
