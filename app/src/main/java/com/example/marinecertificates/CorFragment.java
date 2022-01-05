package com.example.marinecertificates;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Date;

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
        CardItem circle = new CardItem("0", "STCW", R.drawable.stcw,2,"Course","add");
        CorList.add(circle);

        CardItem triangle = new CardItem("1","LNG SHIPS", R.drawable.lng,3,"Course","webf j");
        CorList.add(triangle);

        CardItem square = new CardItem("2","STCW", R.drawable.stcw,4,"Course","nwehjfbjwebh ");
        CorList.add(square);

        CardItem rectangle = new CardItem("3","LNG SHIPS", R.drawable.lng,2,"Course","jbjsf nwef");
        CorList.add(rectangle);

        CardItem octagon = new CardItem("4","STCW", R.drawable.stcw,6,"Course","k kefjef hebf");
        CorList.add(octagon);

        CardItem circle2 = new CardItem("5", "LNG SHIPS 2", R.drawable.lng,6,"Course","jke wefj ");
        CorList.add(circle2);

        CardItem triangle2 = new CardItem("6","STCW 2", R.drawable.stcw,4,"Course","iwf jwenweewwef");
        CorList.add(triangle2);

        CardItem square2 = new CardItem("7","LNG SHIPS 2", R.drawable.lng,3,"Course","iiuo jefw ");
        CorList.add(square2);

        CardItem rectangle2 = new CardItem("8","STCW 2", R.drawable.stcw,4,"Course","bfe wfmejn fwebf jwef");
        CorList.add(rectangle2);

        CardItem octagon2 = new CardItem("9","LNG SHIPS 2", R.drawable.lng,6,"Course","ijirj rgnr hgbefbwe w ");
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
                ArrayList<CardItem> filteredShapes = new ArrayList<CardItem>();
                for (CardItem cardItem: CorList)
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
