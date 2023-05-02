package com.example.harjoitustyo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    TextView lutemonName;
    TextView color;
    TextView attack;
    TextView defence;
    TextView hitPoints;
    TextView experience;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);

        lutemonName = itemView.findViewById(R.id.txtLutemonName);
        color = itemView.findViewById(R.id.txtColor);
        attack = itemView.findViewById(R.id.txtAttack);
        defence = itemView.findViewById(R.id.txtDefence);
        hitPoints = itemView.findViewById(R.id.txtHitPoints);
        experience = itemView.findViewById(R.id.txtExperience);
    }
}
