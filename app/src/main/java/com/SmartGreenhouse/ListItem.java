package com.SmartGreenhouse;
public class ListItem {




    private String text;
    private int imageResId;






    public ListItem(String text, int imageResId) {
        this.text = text;
        this.imageResId = imageResId;
    }


    public String getText() {
        return text;
    }

    public int getImageResId() {
        return imageResId;
    }




}
