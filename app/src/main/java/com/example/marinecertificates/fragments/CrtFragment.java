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

public class CrtFragment extends Fragment {


    public CrtFragment() {
        // Required empty public constructor
    }

    public static ArrayList<CardItem> CrtList = new ArrayList<>();
    private View view;
    private ListView listView;
    private SearchView searchView;
    private String currentSearchText = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_crt,container,false);
        setupData();
        setUpList();
        setUpOnclickListener();
        initSearchWidgets();
        return view;
    }



    private void setupData()
    {
        CardItem circle = new CardItem("0", "STCW", R.drawable.stcw,5,"Certificate",getResources().getString(R.string.STCWCRT_Discrip));
        CrtList.add(circle);

        CardItem triangle = new CardItem("1","Chief Officer", R.drawable.lng,5,"Certificate",getResources().getString(R.string.ChiefOfficer_Discrip));
        CrtList.add(triangle);

        CardItem square = new CardItem("2","Third Officer", R.drawable.stcw,5,"Certificate",getResources().getString(R.string.ThirdOfficer_Discrip));
        CrtList.add(square);

        CardItem rectangle = new CardItem("3","LNG SHIPS", R.drawable.lng,5,"Certificate",getResources().getString(R.string.STCW_Discrip));
        CrtList.add(rectangle);

        CardItem octagon = new CardItem("4","STCW", R.drawable.stcw,5,"Certificate",getResources().getString(R.string.STCW_Discrip));
        CrtList.add(octagon);

        CardItem circle2 = new CardItem("5", "LNG SHIPS 2", R.drawable.lng,5,"Certificate",getResources().getString(R.string.STCW_Discrip));
        CrtList.add(circle2);

        CardItem triangle2 = new CardItem("6","STCW 2", R.drawable.stcw,5,"Certificate",getResources().getString(R.string.STCW_Discrip));
        CrtList.add(triangle2);

        CardItem square2 = new CardItem("7","LNG SHIPS 2", R.drawable.lng,5,"Certificate",getResources().getString(R.string.STCW_Discrip));
        CrtList.add(square2);

        CardItem rectangle2 = new CardItem("8","STCW 2", R.drawable.stcw,5,"Certificate",getResources().getString(R.string.STCW_Discrip));
        CrtList.add(rectangle2);

        CardItem octagon2 = new CardItem("9","LNG SHIPS 2", R.drawable.lng,5,"Certificate",getResources().getString(R.string.STCW_Discrip));
        CrtList.add(octagon2);
    }

    private void setUpList()
    {
        listView = view.findViewById(R.id.lv_crt);

        CardItemAdapter adapter = new CardItemAdapter(requireActivity().getApplicationContext(), 0, CrtList,false);
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
                showDetails.putExtra("from", "crt");
                startActivity(showDetails);
            }

        });
    }
    private void initSearchWidgets()
    {
        searchView = (SearchView) view.findViewById(R.id.sv_crt);
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
                ArrayList<CardItem> filteredShapes = new ArrayList<CardItem>();
                for (CardItem cardItem: CrtList)
                {
                    if(cardItem.getName().toLowerCase().contains(s.toLowerCase()))
                    {
                        filteredShapes.add(cardItem);
                    }
                }

                CardItemAdapter adapter = new CardItemAdapter((requireActivity().getApplicationContext()),0, filteredShapes,false);
                listView.setAdapter(adapter);

                return false;
            }
        });
    }
}