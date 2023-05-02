package com.example.harjoitustyo.areas;

public class Graveyard extends Storage {

    private static Graveyard graveyard = null;
    protected Graveyard() {
        super("Graveyard");
    }

    public static Graveyard getInstance() {
        if (graveyard == null) {
            graveyard = new Graveyard();
        }
        return graveyard;
    }
}
