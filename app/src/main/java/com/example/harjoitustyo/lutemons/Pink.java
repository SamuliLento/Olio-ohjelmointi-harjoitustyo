package com.example.harjoitustyo.lutemons;

public class Pink extends Lutemon {

    public Pink (String name) {
        this.name = name;
        color = "Pink";
        attack = 7;
        defence = 2;
        experience = 0;
        hitPoints = 18;
        maxHitPoints = 18;
        id = getNumberOfCreatedLutemons();
    }
}
