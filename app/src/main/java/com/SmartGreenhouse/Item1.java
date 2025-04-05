package com.SmartGreenhouse;

public class Item1 {
    private String title;
    private String value;
    private int iconResId; // Ressource de l'icône

    public Item1(String title, String value, int iconResId) {
        this.title = title;
        this.value = value;
        this.iconResId = iconResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }
}
