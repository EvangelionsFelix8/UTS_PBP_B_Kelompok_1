package com.example.uts_pbp_b_kelompok_1;

import java.util.ArrayList;

public class DummyEvent {

    public ArrayList<Event> dataEvent;

    public DummyEvent(){
        dataEvent = new ArrayList();
        dataEvent.add(event1);
        dataEvent.add(event2);
        dataEvent.add(event3);
        dataEvent.add(event4);
    }

    public static final Event event1 = new Event(
            "5 Juni 2022",
            "Pentas Kebudayaan Solo",
            "https://lh3.googleusercontent.com/proxy/CBofyF-mgUa1cNXqmh4yTLjL1RobPLhc2dl935GbM7mT1CsJulu5mgLMUznm7VpNceb6srrrNpD-BpYDGbrGY7kEQ-WTtejVV503jL4_v2_o7uD7hDEL");
    public static final Event event2 = new Event(
            "25 Desember 2021",
            "Konser Musik Rock",
            "https://i1.wp.com/musikeras.com/wp-content/uploads/2018/05/AMBANG-CHRIST-edit.png?fit=900%2C486&quality=95&ssl=1");
    public static final Event event3 = new Event(
            "11 November 2021",
            "Konser Jazz Night Live",
            "https://rebornprojectmedia.com/wp-content/uploads/2019/06/Karakter-Penyuka-Musik-Jazz.jpg");
    public static final Event event4 = new Event(
            "1 Januari 2022",
            "Pentas Seni Budaya",
            "https://lh3.googleusercontent.com/proxy/g-0ngTRI-5IsH8zOk4hCDgO3N0HOMcJUBoOvhuMmhb2BzmREpuzZPbhQ32jjTUbqlr20xkf0eVUbbQWs8hgRjAi8eoqExJG4G2L_GlIJ6LRNP5MkVrEDr6hT7WuIw9KXwcBGdIADRwccwamqjW3cpz9DTEdLOlOuzmuQ3w5UFjJFdNAKUrMkYQ");

}
