package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import com.example.songr.repos.AlbumCrud;
import com.example.songr.repos.SongCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.List;

@Controller

public class AlbumControl {


    @Autowired
    AlbumCrud albumCrud;
    @Autowired
    SongCrud songCrud;

    @GetMapping("/album")
    public  String addAlbum(Model model){
//        Album album1 = new Album("Blackbird", "Alter bridge","13", "59:17", "https://upload.wikimedia.org/wikipedia/en/1/13/Alterbridge_blackbird.jpg" );
//        albumCrud.save(album1);
//        Album album2 = new Album("Dark Passion Play", "Nightwish","13", "75:36", "https://upload.wikimedia.org/wikipedia/en/5/5e/Dark_Passion_Play.jpg" );
//        albumCrud.save(album2);
//        Album album3 = new Album("Unsung Heroes", "Ensiferum","8", "61:19", "https://upload.wikimedia.org/wikipedia/en/a/a7/Ensiferum_-_Unsung_Heroes.jpg");
//        albumCrud.save(album3);

        List<Album> data = (ArrayList<Album>) albumCrud.findAll();
        model.addAttribute("albums", data);
        return "album";
    }


    @PostMapping("/album")
    public RedirectView  greetingSubmit(@ModelAttribute Album album, Model model) {
        model.addAttribute("album", album);
        albumCrud.save(album);
        return new RedirectView("/album");
    }


    @GetMapping("/albumpage/{id}")
    public String getSpecificAlbums(Model model ,@PathVariable long id){
            Album album =  albumCrud.findById(id).get();
        model.addAttribute("albums",album);

            return "songs";

    }


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
