package com.example.uts_pbp_b_kelompok_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp_b_kelompok_1.Database.Database;
import com.example.uts_pbp_b_kelompok_1.DetailEventActivity;
import com.example.uts_pbp_b_kelompok_1.Entity.TicketRoom;
import com.example.uts_pbp_b_kelompok_1.FragmentDetailTicket;
import com.example.uts_pbp_b_kelompok_1.FragmentRiwayatKosong;
import com.example.uts_pbp_b_kelompok_1.OrderActivity;
import com.example.uts_pbp_b_kelompok_1.Preferences.UserPreferences;
import com.example.uts_pbp_b_kelompok_1.R;
import com.google.gson.Gson;

import java.util.List;

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.viewHolder> {

    private List<TicketRoom> ticketList;
    private Context context;
    private Database database;
    private UserPreferences userPreferences;

    public RiwayatAdapter(List<TicketRoom> ticketList, Context context)
    {
        this.ticketList = ticketList;
        this.context = context;
        this.userPreferences = new UserPreferences(context);
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private TextView tvKodeBooking;
        private TextView tvTanggal;
        private TextView tvNamaEvent;
        private TextView tvVenue;
        private TextView tvNamaPemilik;
        private ImageView ivLogoEvent;
        private CardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvKodeBooking = itemView.findViewById(R.id.tvKodeBooking);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);
            tvNamaEvent = itemView.findViewById(R.id.tvNamaEventRiwayat);
            tvVenue = itemView.findViewById(R.id.tvVenueRiwayat);
            tvNamaPemilik = itemView.findViewById(R.id.tvNamaPemilik);
            cardView = itemView.findViewById(R.id.card_view);
//            ivLogoEvent = itemView.findViewById(R.id.ivLogoEvent);
        }

        public void setData(String ticket, int position){
            tvKodeBooking.setText(ticket);
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
        holder.tvKodeBooking.setText(Integer.toString(ticket.getKodeticket()));
        holder.tvTanggal.setText(ticket.getEventDate());
        holder.tvNamaEvent.setText(ticket.getEventName());
        holder.tvVenue.setText(ticket.getEventVenue());
        holder.tvNamaPemilik.setText(ticket.getNamaPemilik());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment frag = FragmentDetailTicket.newInstance(ticket.getKodeticket(), ticket.getEventName(),
                        ticket.getNamaPemilik(), ticket.getSeatSection(), ticket.getSeatNumber(),
                        ticket.getEventDate(), ticket.getEventVenue());
                FragmentManager fm = frag.getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.layout_fragment, frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }
}
