package com.example.marinecertificates;

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
    int yearPeriod;

    public void setYearPeriod(int yearPeriod) {
        this.yearPeriod = yearPeriod;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }




    public CardItem(String id, String name, int image, int yearPeriod, String itemType,String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.yearPeriod = yearPeriod;
        this.itemType = itemType;
        this.description = description;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }
    public int getYearPeriod() {
        return yearPeriod;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}
