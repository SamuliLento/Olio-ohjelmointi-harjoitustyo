package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.harjoitustyo.areas.Home;
import com.example.harjoitustyo.lutemons.Black;
import com.example.harjoitustyo.lutemons.Green;
import com.example.harjoitustyo.lutemons.Lutemon;
import com.example.harjoitustyo.lutemons.Orange;
import com.example.harjoitustyo.lutemons.Pink;
import com.example.harjoitustyo.lutemons.White;

public class CreateLutemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lutemon);
    }

    public void createLutemon(View view) {

        EditText name = findViewById(R.id.editName);
        RadioGroup rgColor = findViewById(R.id.rgColor);
        Lutemon lutemon;

        switch (rgColor.getCheckedRadioButtonId()) {
            case R.id.rbBlack:
                lutemon = new Black(name.getText().toString());
                Home.getInstance().addLutemon(lutemon);
                break;
            case R.id.rbGreen:
                lutemon = new Green(name.getText().toString());
                Home.getInstance().addLutemon(lutemon);
                break;
            case R.id.rbOrange:
                lutemon = new Orange(name.getText().toString());
                Home.getInstance().addLutemon(lutemon);
                break;
            case R.id.rbPink:
                lutemon = new Pink(name.getText().toString());
                Home.getInstance().addLutemon(lutemon);
                break;
            case R.id.rbWhite:
                lutemon = new White(name.getText().toString());
                Home.getInstance().addLutemon(lutemon);
                break;
        }
        rgColor.clearCheck();
    }
}