package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.harjoitustyo.areas.BattleField;
import com.example.harjoitustyo.areas.Home;
import com.example.harjoitustyo.areas.TrainingArea;
import com.example.harjoitustyo.lutemons.Lutemon;

import java.util.ArrayList;

public class MoveLutemonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemons);
        makeRadioButtons();
    }

    public void makeRadioButtons() {
        RadioGroup rgLutemons = findViewById(R.id.rgLutemons);
        rgLutemons.removeAllViews();

        ArrayList<Lutemon> lutemons = Home.getInstance().getLutemons();

        RadioButton rb;
        int i = 0;
        for (Lutemon lutemon : lutemons) {
            rb = new RadioButton(this);
            rb.setText(lutemon.getName() + " (id: " + lutemon.getId() + " color: " + lutemon.getColor() + ")");
            rb.setId(i++);
            rgLutemons.addView(rb);
        }
        rgLutemons.clearCheck();
    }

    public void moveLutemon(View view) {
        RadioGroup rgLutemons = findViewById(R.id.rgLutemons);
        RadioGroup rgLocations = findViewById(R.id.rgLocations);

        if (rgLutemons.getCheckedRadioButtonId() != -1) {
            Lutemon lutemon = Home.getInstance().getLutemon(rgLutemons.getCheckedRadioButtonId());
            switch (rgLocations.getCheckedRadioButtonId()) {
                case R.id.rbTrainingArea:
                    TrainingArea.getInstance().addLutemon(lutemon);
                    Home.getInstance().removeLutemon(lutemon.getId());
                    break;
                case R.id.rbBattleField:
                    BattleField.getInstance().addLutemon(lutemon);
                    Home.getInstance().removeLutemon(lutemon.getId());
                    break;
            }
            makeRadioButtons();
        }
        rgLocations.clearCheck();
    }
}