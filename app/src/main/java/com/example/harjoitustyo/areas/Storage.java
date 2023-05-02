package com.example.harjoitustyo.areas;

import com.example.harjoitustyo.lutemons.Lutemon;

import java.util.ArrayList;

public abstract class Storage {

    protected String name;
    protected ArrayList<Lutemon> lutemons;

    protected Storage(String name) {
        this.name = name;
        lutemons = new ArrayList<Lutemon>();
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }


    public void removeLutemon(int id) {
        int i = 0;
        for (Lutemon lutemon: lutemons) {
            if (lutemon.getId() == id) {
                break;
            }
            i++;
        }
        lutemons.remove(i);
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

}
