package com.example.harjoitustyo.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.harjoitustyo.CreateLutemonActivity;
import com.example.harjoitustyo.ListLutemonsActivity;
import com.example.harjoitustyo.MoveLutemonsActivity;
import com.example.harjoitustyo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentHome() {
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
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnCreateLutemon = getView().findViewById(R.id.btnCreateLutemon);
        Button btnListLutemons = getView().findViewById(R.id.btnListLutemons);
        Button btnMoveLutemons = getView().findViewById(R.id.btnMoveLutemons);

        btnCreateLutemon.setOnClickListener(listener);
        btnListLutemons.setOnClickListener(listener);
        btnMoveLutemons.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent;

            switch (view.getId()) {
                case R.id.btnCreateLutemon:
                    intent = new Intent(view.getContext(), CreateLutemonActivity.class);
                    startActivity(intent);
                    return;
                case R.id.btnListLutemons:
                    intent = new Intent(view.getContext(), ListLutemonsActivity.class);
                    startActivity(intent);
                    return;
                case R.id.btnMoveLutemons:
                    intent = new Intent(view.getContext(), MoveLutemonsActivity.class);
                    startActivity(intent);
                    return;
                default:
                    break;
            }
        }
    };

}