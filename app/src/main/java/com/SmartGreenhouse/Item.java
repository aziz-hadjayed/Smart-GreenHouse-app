package com.SmartGreenhouse;

public class Item
{
    private String title ;
    private String text;
    private int imageResId;

    public Item(String title, String text, int imageResId)
    {
        this.title = title ;
        this.text = text;
        this.imageResId = imageResId;
    }


    public String getTitle()
    {
        return title;
    }

    public String getText()
    {
        return text;
    }

    public int getImageResId()
    {
        return imageResId;
    }

}
