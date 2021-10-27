package com.example.songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String artist;
    private String songCount;
    private String length;
    private String imageUrl;

    public List<Song> getAlbumSongs() {
        return albumSongs;
    }

    public void setAlbumSongs(List<Song> albumSongs) {
        this.albumSongs = albumSongs;
    }

    @OneToMany(mappedBy = "albumSongs")
    List<Song> albumSongs;


    public Album(){}


    public Album(String title, String artist, String songCount, String length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongCount() {
        return songCount;
    }

    public void setSongCount(String songCount) {
        this.songCount = songCount;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
