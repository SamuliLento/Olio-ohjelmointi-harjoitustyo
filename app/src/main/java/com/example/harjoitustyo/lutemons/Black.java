package com.example.harjoitustyo.lutemons;

public class Black extends Lutemon {

    public Black (String name) {
        this.name = name;
        color = "Black";
        attack = 9;
        defence = 0;
        experience = 0;
        hitPoints = 16;
        maxHitPoints = 16;
        id = getNumberOfCreatedLutemons();
    }
}
