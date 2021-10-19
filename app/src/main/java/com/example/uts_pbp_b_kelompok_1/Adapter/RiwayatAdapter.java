package com.example.uts_pbp_b_kelompok_1.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp_b_kelompok_1.Entity.TicketRoom;
import com.example.uts_pbp_b_kelompok_1.Model.User;
import com.example.uts_pbp_b_kelompok_1.Preferences.UserPreferences;
import com.example.uts_pbp_b_kelompok_1.R;

import java.util.List;

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.viewHolder> {

    private List<TicketRoom> ticketList;
    private Context context;

    public RiwayatAdapter(List<TicketRoom> ticketList, Context context)
    {
        this.ticketList = ticketList;
        this.context = context;
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView tvKodeBooking;
        TextView tvTanggal;
        TextView tvNamaEvent;
        TextView tvVenue;
        TextView tvNamaPemilik;
        ImageView ivLogoEvent;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvKodeBooking = itemView.findViewById(R.id.tvKodeBooking);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);
            tvNamaEvent = itemView.findViewById(R.id.tvNamaEventRiwayat);
            tvVenue = itemView.findViewById(R.id.tvVenue);
            tvNamaPemilik = itemView.findViewById(R.id.tvNamaPemilik);
            ivLogoEvent = itemView.findViewById(R.id.ivLogoEvent);
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_riwayat,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TicketRoom ticket = ticketList.get(position);
        holder.tvKodeBooking.setText(ticket.getKodeticket());
        holder.tvTanggal.setText(ticket.getEventDate());
        holder.tvNamaEvent.setText(ticket.getEventName());
        holder.tvVenue.setText(ticket.getEventVenue());
        holder.tvNamaPemilik.setText(ticket.getNamaPemilik());
//        holder.ivLogoEvent.setText(ticket.getKodeticket());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View itemView) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }


}
