package com.example.harjoitustyo.lutemons;

public abstract class Lutemon {

    protected String name;
    protected String color;
    protected int attack;
    protected int defence;
    protected int experience;
    protected int hitPoints;
    protected int maxHitPoints;
    protected int id;
    private static int idCounter = 0;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getExperience() {
        return experience;
    }

    //Increases Lutemons experience and attack
    public void setExperience(int i) {
        this.experience = this.experience + i;
        this.attack = this.attack + i;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    //Heals Lutemon to full HP
    public void heal() {
        this.hitPoints = this.maxHitPoints;
    }

    //Lutemon defends against attack
    public void defend(int attack) {
        this.hitPoints = this.hitPoints - (attack - this.defence);
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public int getId() {
        return id;
    }

    //Returns Lutemons stats as a String
    public String printStats() {
        return (this.id + ": " + this.name + " (" + this.color + ") att: " + this.attack + "; def: " + this.defence + "; exp: " + this.experience + "; hit points: " + this.hitPoints + "/" + this.maxHitPoints + "\n");
    }

    public int getNumberOfCreatedLutemons() {
        return idCounter++;
    }
}
