package com.example.alexandru.pdf.model;

public class Song {

    private int id;
    private String nameSong;
    private String textSong;
    private String categorySong;
    private String nameSongNoRom;

    public Song() {
    }

    public Song(int id, String nameSong, String textSong, String categorySong, String nameSongNoRom) {
        this.id = id;
        this.nameSong = nameSong;
        this.textSong = textSong;
        this.categorySong = categorySong;
        this.nameSongNoRom = nameSongNoRom;
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

    public String getCategorySong() {
        return categorySong;
    }

    public void setCategorySong(String categorySong) {
        this.categorySong = categorySong;
    }

    public String getNameSongNoRom() {
        return nameSongNoRom;
    }

    public void setNameSongNoRom(String nameSongNoRom) {
        this.nameSongNoRom = nameSongNoRom;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", nameSong='" + nameSong + '\'' +
                ", textSong='" + textSong + '\'' +
                ", categorySong='" + categorySong + '\'' +
                ", nameSongNoRom='" + nameSongNoRom + '\'' +
                '}';
    }
}
