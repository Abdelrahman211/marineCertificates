package com.example.marinecertificates.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.marinecertificates.activities.DetailsActivity;
import com.example.marinecertificates.activities.DetailsProfileActivity;
import com.example.marinecertificates.adapters.CardItemAdapter;
import com.example.marinecertificates.MarineCertificatesApp;
import com.example.marinecertificates.models.CardItem;
import com.example.marinecertificates.models.ProfileList;
import com.example.marinecertificates.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ProfileFragment extends Fragment {



    public ProfileFragment() {
        // Required empty public constructor
    }

    private View view;
    private ListView listView;
    private ProfileList mProfileList;
    private ArrayList<CardItem> mAllList;
    private ArrayList<CardItem> mValidList;
    private ArrayList<CardItem> mExpiredList;
    CardItemAdapter adapter;

    Button allBtn;
    Button validBtn;
    Button expiredBtn;
    String inList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_profile,container,false);

        allBtn = view.findViewById(R.id.bnt_all_crt);
        validBtn = view.findViewById(R.id.bnt_valid_crt);
        expiredBtn = view.findViewById(R.id.bnt_expired_crt);
        mProfileList = ((MarineCertificatesApp) getActivity().getApplicationContext()).myProfileList;
        inList = "all";
        updateDataLists();
        setUpList();
        setUpOnclickListener();



        return view;
        
    }

    void updateDataLists(){
        mAllList =  mProfileList.addedItems;
        mValidList  = new ArrayList<CardItem>();
        mExpiredList  = new ArrayList<CardItem>();

        Date currDate = Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();

        for(int i= 0; i<mAllList.size();i++){
            cal.setTime(mAllList.get(i).getDate());
            cal.add(Calendar.YEAR,mAllList.get(i).getYearPeriod());
            if(currDate.after(cal.getTime())){
                mValidList.add(mAllList.get(i));
            }
            else{
                mExpiredList.add(mAllList.get(i));
            }

        }


    }
    @Override
    public void onResume() {
        super.onResume();
        updateDataLists();
        if(inList.equals( "all"))
            adapter = new CardItemAdapter((requireActivity().getApplicationContext()), 0, mAllList,true);
        else if(inList.equals( "valid"))
            adapter = new CardItemAdapter((requireActivity().getApplicationContext()), 0, mValidList,true);
        else
            adapter = new CardItemAdapter((requireActivity().getApplicationContext()), 0, mExpiredList,true);
        listView.setAdapter(adapter);
    }

    private void setUpList()
    {
        listView = view.findViewById(R.id.lv_profile);

        MarineCertificatesApp app = (MarineCertificatesApp) getActivity().getApplication();
        adapter = new CardItemAdapter(app.getContext(), 0, mAllList,true);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        validBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDataLists();
                inList = "valid";
                adapter = new CardItemAdapter((requireActivity().getApplicationContext()),0, mValidList,true);
                listView.setAdapter(adapter);

            }
        });

        expiredBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDataLists();
                inList = "expired";
                adapter = new CardItemAdapter((requireActivity().getApplicationContext()),0, mExpiredList,true);
                listView.setAdapter(adapter);

            }
        });

        allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDataLists();
                inList = "all";
                adapter = new CardItemAdapter((requireActivity().getApplicationContext()),0, mAllList,true);
                listView.setAdapter(adapter);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent showDetails = new Intent(getActivity(), DetailsProfileActivity.class);
                if(inList.equals( "all"))
                    showDetails.putExtra("id",mAllList.get(position).getId());
                else if(inList.equals( "valid"))
                    showDetails.putExtra("id",mValidList.get(position).getId());
                else
                    showDetails.putExtra("id",mExpiredList.get(position).getId());



                startActivity(showDetails);

            }

        });
    }



}