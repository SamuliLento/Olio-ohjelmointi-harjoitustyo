package com.example.harjoitustyo.areas;

import com.example.harjoitustyo.lutemons.Lutemon;

public class TrainingArea extends Storage {

    private static TrainingArea trainingArea = null;
    protected TrainingArea() {
        super("Training Area");
    }

    public static TrainingArea getInstance() {
        if (trainingArea == null) {
            trainingArea = new TrainingArea();
        }
        return trainingArea;
    }

    //Lutemon gains experience and returns home
    public void train(Lutemon lutemon) {
        lutemon.setExperience(1);
        Home.getInstance().addLutemon(lutemon);
        TrainingArea.getInstance().removeLutemon(lutemon.getId());
    }
}
