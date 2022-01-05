package com.example.marinecertificates.models;

import android.view.ViewDebug;

import java.util.ArrayList;

public class ProfileList   {

    public ArrayList<CardItem> addedItems = new ArrayList<CardItem> ();



    public void addItem(CardItem myItem) {
        myItem.setId(Integer.toString(addedItems.size()));
        addedItems.add(myItem);

    }

    public CardItem getItemById(String id){
        for(int i = 0; i<addedItems.size();i++){
            if(addedItems.get(i).getId().equals(id)){
                return addedItems.get(i);
            }
        }
        return null;
    }
    public void removeItem(String id ) {
        int idxRemoved = -1;
        for(int i = 0; i<addedItems.size();i++){
            if(addedItems.get(i).getId().equals(id)){
                addedItems.remove(i);
                idxRemoved = i;
                break;
            }
        }
        if(idxRemoved!= -1){
            for(int i = idxRemoved; i<addedItems.size();i++){
                addedItems.get(i).setId(Integer.toString(i));
            }
        }

    }



    public String getName() {
        return null;
    }
}
