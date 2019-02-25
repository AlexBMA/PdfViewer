package com.example.alexandru.pdf.utilsModel;

public class ListItemModel {

    private String songTitle;
    private int id;

    public ListItemModel() {
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ListItemModel{" +
                "songTitle='" + songTitle + '\'' +
                ", id=" + id +
                '}';
    }
}
