package com.example.harjoitustyo.lutemons;

public class White extends Lutemon {

    public White (String name) {
        this.name = name;
        color = "White";
        attack = 5;
        defence = 4;
        experience = 0;
        hitPoints = 20;
        maxHitPoints = 20;
        id = getNumberOfCreatedLutemons();
    }
}
