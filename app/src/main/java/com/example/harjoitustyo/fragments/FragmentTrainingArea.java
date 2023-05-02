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
import com.example.harjoitustyo.areas.TrainingArea;
import com.example.harjoitustyo.lutemons.Lutemon;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTrainingArea#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTrainingArea extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTrainingArea() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTrainingArea.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTrainingArea newInstance(String param1, String param2) {
        FragmentTrainingArea fragment = new FragmentTrainingArea();
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
        View view = inflater.inflate(R.layout.fragment_training_area, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        makeRadioButtons();

        Button btnTrainLutemon = getView().findViewById(R.id.btnTrainLutemon);

        btnTrainLutemon.setOnClickListener(listener);
    }

    @Override
    public void onResume() {
        super.onResume();
        makeRadioButtons();
    }

    public void makeRadioButtons() {
        RadioGroup rgTrain = getView().findViewById(R.id.rgTrain);
        rgTrain.removeAllViews();

        ArrayList<Lutemon> lutemons = TrainingArea.getInstance().getLutemons();

        RadioButton rb;
        int i = 0;
        for (Lutemon lutemon : lutemons) {
            rb = new RadioButton(getView().getContext());
            rb.setText(lutemon.getName() + " (id: " + lutemon.getId() + " color: " + lutemon.getColor() + ")");
            rb.setId(i++);
            rgTrain.addView(rb);
        }
        rgTrain.clearCheck();
    }

    public void trainLutemon() {
        RadioGroup rgTrain = getView().findViewById(R.id.rgTrain);

        if (rgTrain.getCheckedRadioButtonId() != -1) {
            Lutemon lutemon = TrainingArea.getInstance().getLutemon(rgTrain.getCheckedRadioButtonId());

            TrainingArea.getInstance().train(lutemon);

            TextView txtTrain = getView().findViewById(R.id.txtTrain);
            txtTrain.setText(lutemon.getName() + " gained experience and returned home");

            makeRadioButtons();
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.btnTrainLutemon:
                    trainLutemon();
                    break;
            }
        }
    };
}