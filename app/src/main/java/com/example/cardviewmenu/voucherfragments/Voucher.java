package com.example.cardviewmenu.voucherfragments;

public class Voucher {
    String image;
    String point;
    String name;
    String terms;

    public Voucher(String Point, String image, String name, String terms) {
        this.point = Point;
        this.image = image;
        this.name = name;
        this.terms = terms;
    }
}
