package com.digitalmarketing.udacitymusicapp;

public class Category {

    private String musicCategory;
    private int ImageId;

    public String getMusiccategory() {
        return musicCategory;
    }

    public int getImageid() {
        return ImageId;
    }

    public Category(String musiccategory, int imageid) {
        this.musicCategory = musiccategory;
        this.ImageId = imageid;
    }
}
