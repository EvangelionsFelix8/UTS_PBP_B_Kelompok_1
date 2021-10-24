package com.example.uts_pbp_b_kelompok_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp_b_kelompok_1.Database.Database;
import com.example.uts_pbp_b_kelompok_1.Entity.TicketRoom;
import com.example.uts_pbp_b_kelompok_1.Preferences.UserPreferences;
import com.example.uts_pbp_b_kelompok_1.R;
import com.google.android.material.button.MaterialButton;

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
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View newLayout = LayoutInflater.from(builder.getContext()).inflate(R.layout.fragment_detail_ticket, null);

//                Deklarasi Atribut dari Fragment
                TextView tvNamaEvent, tvPemilikTiket, tvKodeBooking, tvSection, tvTanggalWaktu, tvVenue, tvSeat;
                MaterialButton btnBack;

//                Mendapatkan Id pada activity
                tvNamaEvent = newLayout.findViewById(R.id.tvNamaTiket);
                tvPemilikTiket = newLayout.findViewById(R.id.tvNamaPemilikTiket);
                tvKodeBooking = newLayout.findViewById(R.id.tvKodeBookingTiket);
                tvSection = newLayout.findViewById(R.id.tvSectionTiket);
                tvTanggalWaktu = newLayout.findViewById(R.id.tvTanggalTiket);
                tvVenue = newLayout.findViewById(R.id.tvVenueTiket);
                tvSeat = newLayout.findViewById(R.id.tvSeatNumberTiket);
                btnBack = newLayout.findViewById(R.id.btnBack);

//                Mengeset Tampilan TextView
                tvNamaEvent.setText(ticket.getEventName());
                tvPemilikTiket.setText(ticket.getNamaPemilik());
                tvKodeBooking.setText(Integer.toString(ticket.getKodeticket()));
                tvSection.setText(ticket.getSeatSection());
                tvTanggalWaktu.setText(ticket.getEventDate() + "\n" +ticket.getTime());
                tvVenue.setText(ticket.getEventVenue());
                tvSeat.setText(ticket.getSeatNumber());

//                menampilkan View builder dengan layout diolog
                builder.setView(newLayout);

//                Show Dialog
                AlertDialog popup = builder.create();
                popup.show();

                btnBack.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                        popup.dismiss();
                   }
               });
            }
        });
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }
}
