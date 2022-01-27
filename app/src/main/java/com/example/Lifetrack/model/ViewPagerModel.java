package com.example.Lifetrack.model;

public class ViewPagerModel {
    private String title;
    private String description;
    private int animation;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getAnimation() {
        return animation;
    }

    public ViewPagerModel(String title, String description, int animation) {
        this.title = title;
        this.description = description;
        this.animation = animation;
    }
}


