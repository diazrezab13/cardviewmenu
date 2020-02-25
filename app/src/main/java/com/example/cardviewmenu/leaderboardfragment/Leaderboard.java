package com.example.cardviewmenu.leaderboardfragment;

public class Leaderboard {
    String Image;
    String Nama;
    String Point;
    String Peringkat;

    public Leaderboard(String Peringkat,String Nama, String Point, String image) {
        this.Peringkat = Peringkat;
        this.Nama = Nama;
        this.Point = Point;
        this.Image = image;
    }
}
