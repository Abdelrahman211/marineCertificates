package com.example.marinecertificates.models;

import java.util.Date;

public class CardItem
{

    private String id;
    private String name;
    private int image;
    private Date date;
    private String itemType;
    private Date addedDate;
    private String description;
    private int yearPeriod;



    public CardItem(String id, String name, int image, int yearPeriod, String itemType, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.yearPeriod = yearPeriod;
        this.itemType = itemType;
        this.description = description;

    }



    // setters

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getImage() {
        return image;
    }
    public int getYearPeriod() {
        return yearPeriod;
    }
    public Date getDate() { return date; }
    public String getDescription() {
        return description;
    }
    public Date getAddedDate() {
        return addedDate;
    }
    public String getItemType() {
        return itemType;
    }


    //getters
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public void setDate(Date date) { this.date = date; }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
    public void setYearPeriod(int yearPeriod) {
        this.yearPeriod = yearPeriod;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


}
