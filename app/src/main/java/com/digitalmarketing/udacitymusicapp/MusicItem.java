package com.digitalmarketing.udacitymusicapp;

public class MusicItem {
    private String MusicName;
    private String ArtistName;
    private int ImgId;
    private String MusicUrl;

    public String getMusicurl() {
        return MusicUrl;
    }


    public String getMusicname() {
        return MusicName;
    }

    public String getArtistname() {
        return ArtistName;
    }

    public int getImgId() {
        return ImgId;
    }

    public MusicItem(String musicname, String artistname, int imgId,String musicurl) {
        this.MusicName = musicname;
        this.ArtistName = artistname;
        this.ImgId = imgId;
        this.MusicUrl=musicurl;

    }



}
