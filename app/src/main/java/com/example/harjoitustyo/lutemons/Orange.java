package com.example.harjoitustyo.lutemons;

public class Orange extends Lutemon {

    public Orange (String name) {
        this.name = name;
        color = "Orange";
        attack = 8;
        defence = 1;
        experience = 0;
        hitPoints = 17;
        maxHitPoints = 17;
        id = getNumberOfCreatedLutemons();
    }
}
