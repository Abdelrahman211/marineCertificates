package com.example.marinecertificates.models;

import java.util.ArrayList;

public class ProfileList   {

    public ArrayList<CardItem> addedItems = new ArrayList<CardItem> ();


    public void addItem(CardItem myItem) {
        addedItems.add(myItem);
    }

    public void removeItem(int idx ) {
        addedItems.remove(idx);
    }


    public String getName() {
        return null;
    }
}
