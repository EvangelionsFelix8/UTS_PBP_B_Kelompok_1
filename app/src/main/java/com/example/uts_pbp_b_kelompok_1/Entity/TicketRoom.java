package com.example.uts_pbp_b_kelompok_1.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.uts_pbp_b_kelompok_1.Model.User;

@Entity(tableName = "ticket", foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "id_user", childColumns = "id_user", onDelete = ForeignKey.CASCADE)})
public class TicketRoom {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "kode_tiket")
        private int kodeticket;

        @ColumnInfo(name = "id_user")
        private int idUser;

        @ColumnInfo(name = "event_name")
        private String eventName;

        @ColumnInfo(name = "event_date")
        private String eventDate;

        @ColumnInfo(name = "event_time")
        private String time;

        public String getEventAddress() {
                return eventAddress;
        }

        public void setEventAddress(String eventAddress) {
                this.eventAddress = eventAddress;
        }

        @ColumnInfo(name = "event_venue")
        private String eventVenue;

        @ColumnInfo(name = "event_alamat")
        private String eventAddress;

        @ColumnInfo(name = "seat_section")
        private String seatSection;

        @ColumnInfo(name = "seat_number")
        private String seatNumber;

        @ColumnInfo(name = "nama_pemilik")
        private String namaPemilik;

        public int getKodeticket() {
                return kodeticket;
        }

        public void setKodeticket(int kodeticket) {
                this.kodeticket = kodeticket;
        }

        public int getIdUser() {
                return idUser;
        }

        public void setIdUser(int idUser) {
                this.idUser = idUser;
        }

        public String getEventName() {
                return eventName;
        }

        public void setEventName(String eventName) {
                this.eventName = eventName;
        }

        public String getEventDate() {
                return eventDate;
        }

        public void setEventDate(String eventDate) {
                this.eventDate = eventDate;
        }

        public String getTime() {
                return time;
        }

        public void setTime(String time) {
                this.time = time;
        }

        public String getEventVenue() {
                return eventVenue;
        }

        public void setEventVenue(String eventVenue) {
                this.eventVenue = eventVenue;
        }

        public String getSeatSection() {
                return seatSection;
        }

        public void setSeatSection(String seatSection) {
                this.seatSection = seatSection;
        }

        public String getSeatNumber() {
                return seatNumber;
        }

        public void setSeatNumber(String seatNumber) {
                this.seatNumber = seatNumber;
        }

        public String getNamaPemilik() {
                return namaPemilik;
        }

        public void setNamaPemilik(String namaPemilik) {
                this.namaPemilik = namaPemilik;
        }
}
