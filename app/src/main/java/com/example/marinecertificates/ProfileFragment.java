package com.example.marinecertificates;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {



    public ProfileFragment() {
        // Required empty public constructor
    }

    private View view;
    private ListView listView;
    private ProfileList mProfileList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_profile,container,false);
        mProfileList = ((MarineCertificatesApp) getActivity().getApplicationContext()).myProfileList;
        setUpList();


        return view;
        
    }

    private void setUpList()
    {
        listView = view.findViewById(R.id.lv_profile);

        MarineCertificatesApp app = (MarineCertificatesApp) getActivity().getApplication();
        CardItemAdapter adapter = new CardItemAdapter(app.getContext(), 0, mProfileList.addedItems,true);
        listView.setAdapter(adapter);
    }

}