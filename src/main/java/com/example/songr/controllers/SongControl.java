package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.repos.AlbumCrud;
import com.example.songr.models.Song;
import com.example.songr.repos.SongCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SongControl {

    @Autowired

    SongCrud songCrud;

    @Autowired
    AlbumCrud albumCrud;


    @PostMapping("/songs/{id}")
    public String addSongToDB(Model model , @PathVariable long id,
                              @RequestParam(value="title")String title,
                              @RequestParam(value="length")int length,
                              @RequestParam(value="trackNumber")int trackNumber)
    {

        Album album = new Album();
        if (albumCrud.findById(id).isPresent()){
            album = albumCrud.findById(id).get();
        } else {

            return "error";
        }
        model.addAttribute("albums", album);
        Song song = new Song(title, length,trackNumber,album);
        songCrud.save(song);

        return "songs";

    }



}

