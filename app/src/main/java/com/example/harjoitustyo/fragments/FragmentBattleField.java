package com.example.harjoitustyo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.harjoitustyo.R;
import com.example.harjoitustyo.areas.BattleField;
import com.example.harjoitustyo.lutemons.Lutemon;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBattleField#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBattleField extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentBattleField() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBattleField.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBattleField newInstance(String param1, String param2) {
        FragmentBattleField fragment = new FragmentBattleField();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_battle_field, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        makeRadioButtons();

        Button btnBattle = getView().findViewById(R.id.btnBattle);

        btnBattle.setOnClickListener(listener);
    }

    @Override
    public void onResume() {
        super.onResume();
        makeRadioButtons();
    }

    public void makeRadioButtons() {
        RadioGroup rgBattle1 = getView().findViewById(R.id.rgBattle1);
        RadioGroup rgBattle2 = getView().findViewById(R.id.rgBattle2);
        rgBattle1.removeAllViews();
        rgBattle2.removeAllViews();
        rgBattle1.clearCheck();
        rgBattle2.clearCheck();

        ArrayList<Lutemon> lutemons = BattleField.getInstance().getLutemons();

        RadioButton rb1;
        RadioButton rb2;
        int i = 0;
        for (Lutemon lutemon : lutemons) {
            rb1 = new RadioButton(getView().getContext());
            rb1.setText(lutemon.getName() + " (id: " + lutemon.getId() + " color: " + lutemon.getColor() + ")");
            rb1.setId(i);
            rgBattle1.addView(rb1);
            rb2 = new RadioButton(getView().getContext());
            rb2.setText(lutemon.getName() + " (id: " + lutemon.getId() + " color: " + lutemon.getColor() + ")");
            rb2.setId(i);
            rgBattle2.addView(rb2);
            i++;
        }
    }

    public void battle() {
        RadioGroup rgBattle1 = getView().findViewById(R.id.rgBattle1);
        RadioGroup rgBattle2 = getView().findViewById(R.id.rgBattle2);
        TextView txtBattle = getView().findViewById(R.id.txtBattle);
        txtBattle.setText("");

        if (rgBattle1.getCheckedRadioButtonId() != -1 && rgBattle2.getCheckedRadioButtonId() != -1) {
            Lutemon lutemon1 = BattleField.getInstance().getLutemon(rgBattle1.getCheckedRadioButtonId());
            Lutemon lutemon2 = BattleField.getInstance().getLutemon(rgBattle2.getCheckedRadioButtonId());

            if (lutemon1.getId() == lutemon2.getId()) {
                txtBattle.setText("You selected same lutemon twice!");
            } else {
                txtBattle.setText(BattleField.getInstance().fight(lutemon1, lutemon2));
            }
            makeRadioButtons();
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.btnBattle:
                    battle();
                    break;
            }
        }
    };
}