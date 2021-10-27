package com.example.songr;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String length;
    private int trackNumber;

    @ManyToOne
    private Album albumSongs;

    public Song(String title, String length, int trackNumber) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;

    }

public Song(){}




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }


}
