package com.example.harjoitustyo.lutemons;

public class Green extends Lutemon {

    public Green (String name) {
        this.name = name;
        color = "Green";
        attack = 6;
        defence = 3;
        experience = 0;
        hitPoints = 19;
        maxHitPoints = 19;
        id = getNumberOfCreatedLutemons();
    }
}
