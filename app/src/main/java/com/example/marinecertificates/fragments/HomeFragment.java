package com.example.marinecertificates.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.marinecertificates.R;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Initialize & Assign variable
        Button btn_cre=(Button) view.findViewById(R.id.btn_crt);

        btn_cre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr= getParentFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new CrtFragment());
                fr.commit();

            }
        });


        Button btn_cor=(Button)  view.findViewById(R.id.btn_cor);
        btn_cor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr= getParentFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new CorFragment());
                fr.commit();
            }
        });
        return view;
    }
}