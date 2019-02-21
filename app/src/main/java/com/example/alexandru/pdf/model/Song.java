package com.example.alexandru.pdf.model;

public class Song {

    private int id;
    private String nameSong;
    private String textSong;
    private String cateSong;


    public Song() {
    }

    public Song(String nameSong, String textSong, String cateSong) {
        this.nameSong = nameSong;
        this.textSong = textSong;
        this.cateSong = cateSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getTextSong() {
        return textSong;
    }

    public void setTextSong(String textSong) {
        this.textSong = textSong;
    }

    public String getCateSong() {
        return cateSong;
    }

    public void setCateSong(String cateSong) {
        this.cateSong = cateSong;
    }
}
