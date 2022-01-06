package com.example.marinecertificates.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.marinecertificates.models.CardItem;
import com.example.marinecertificates.adapters.CardItemAdapter;
import com.example.marinecertificates.R;
import com.example.marinecertificates.activities.DetailsActivity;

import java.util.ArrayList;

public class CorFragment extends Fragment {


    public CorFragment() {
        // Required empty public constructor
    }

    public static ArrayList<CardItem> CorList = new ArrayList<>();
    private View view;
    private ListView listView;
    private SearchView searchView;
    private String currentSearchText = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cor,container,false);
        setupData();
        setUpList();
        setUpOnclickListener();
        initSearchWidgets();

        return view;
    }


    private void setupData()
    {
        CardItem circle = new CardItem("0", "STCW", R.drawable.stcw,5,"Certificate" ,getResources().getString(R.string.STCW_Discrip));
        CorList.add(circle);

        CardItem triangle = new CardItem("1","Marine Safety", R.drawable.lng,5,"Certificate",getResources().getString(R.string.MarineSafety_Discrip));
        CorList.add(triangle);

        CardItem square = new CardItem("2","Offshore", R.drawable.stcw,4,"Certificate",getResources().getString(R.string.Offshore_Discrip));
        CorList.add(square);

        CardItem rectangle = new CardItem("3","Marine Simulators", R.drawable.lng,5,"Certificate",getResources().getString(R.string.MarineSimulators_Discrip));
        CorList.add(rectangle);

        CardItem octagon = new CardItem("4","Environmental Protection", R.drawable.stcw,5,"Certificate",getResources().getString(R.string.EnvironmentalProtection_Discrip));
        CorList.add(octagon);

        CardItem triangle2 = new CardItem("6","GMDSS", R.drawable.stcw,5,"Course",getResources().getString(R.string.GMDSS_Discrip));
        CorList.add(triangle2);

        CardItem square2 = new CardItem("7","Diving", R.drawable.lng,5,"Course",getResources().getString(R.string.Diving_Discrip));
        CorList.add(square2);

        CardItem rectangle2 = new CardItem("8","Natural Gas & Petrochemicals", R.drawable.stcw,5,"Course",getResources().getString(R.string.NaturalGas_Petrochemicals_Discrip));
        CorList.add(rectangle2);

        CardItem octagon2 = new CardItem("9","Meteorology & Hydrographic Survey", R.drawable.lng,5,"Course",getResources().getString(R.string.Meteorology_HydrographicSurvey_Discrip));
        CorList.add(octagon2);
    }

    private void setUpList()
    {
        listView = view.findViewById(R.id.lv_cor);

        CardItemAdapter adapter = new CardItemAdapter(requireActivity().getApplicationContext(), 0, CorList,false);
        listView.setAdapter(adapter);
    }
    private void setUpOnclickListener()
    {
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            CardItem selectCardItem = (CardItem) (listView.getItemAtPosition(position));
            Intent showDetails = new Intent(getActivity(), DetailsActivity.class);

            showDetails.putExtra("id",selectCardItem.getId());
            showDetails.putExtra("from", "cor");
            startActivity(showDetails);

        }

    });
    }

    private void initSearchWidgets()
    {
        searchView = (SearchView) view.findViewById(R.id.sv_cor);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                currentSearchText = s;
                ArrayList<CardItem> filteredItems = new ArrayList<CardItem>();
                for (CardItem cardItem: CorList)
                {
                    if(cardItem.getName().toLowerCase().contains(s.toLowerCase()))
                    {
                        filteredItems.add(cardItem);
                    }
                }

                CardItemAdapter adapter = new CardItemAdapter((requireActivity().getApplicationContext()),0, filteredItems,false);
                listView.setAdapter(adapter);

                return false;
            }
        });
    }
}
