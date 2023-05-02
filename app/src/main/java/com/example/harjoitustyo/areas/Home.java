package com.example.harjoitustyo.areas;

public class Home extends Storage {

    private static Home home = null;
    protected Home() {
        super("Home");
    }

    public static Home getInstance() {
        if (home == null) {
            home = new Home();
        }
        return home;
    }
}
