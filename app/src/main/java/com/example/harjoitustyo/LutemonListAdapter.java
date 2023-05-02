package com.example.harjoitustyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harjoitustyo.lutemons.Lutemon;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<Lutemon>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lutemonName.setText(lutemons.get(position).getName() + " (id: " + lutemons.get(position).getId() + ")");
        holder.color.setText("Color: " + lutemons.get(position).getColor());
        holder.attack.setText("Attack: " + lutemons.get(position).getAttack());
        holder.defence.setText("Defence: " + lutemons.get(position).getDefence());
        holder.hitPoints.setText("Hit Points: " + lutemons.get(position).getHitPoints() + "/" + lutemons.get(position).getMaxHitPoints());
        holder.experience.setText("Experience: " + lutemons.get(position).getExperience());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
