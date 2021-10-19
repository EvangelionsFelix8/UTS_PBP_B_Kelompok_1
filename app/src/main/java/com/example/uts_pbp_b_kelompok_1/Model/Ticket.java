package com.example.uts_pbp_b_kelompok_1.Model;

import androidx.room.Entity;

public class Ticket
{
    private String namaEvent;
    private String jenisEvent;
    private String namaPemilik;
    private String kodeBooking;
    private String section;
    private String tanggal;
    private String lokasi;
    private int seatNo;

    public Ticket(String namaPemilik, String kodeBooking, String section, String tanggal,
                  String lokasi, String namaEvent, String jenisEvent, int seatNo)
    {
        this.namaEvent = namaEvent;
        this.jenisEvent = jenisEvent;
        this.namaPemilik = namaPemilik;
        this.kodeBooking = kodeBooking;
        this.section = section;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.seatNo = seatNo;
    }

    public String getJenisEvent() {
        return jenisEvent;
    }

    public void setJenisEvent(String jenisEvent) {
        this.jenisEvent = jenisEvent;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getKodeBooking() {
        return kodeBooking;
    }

    public void setKodeBooking(String kodeBooking) {
        this.kodeBooking = kodeBooking;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}
