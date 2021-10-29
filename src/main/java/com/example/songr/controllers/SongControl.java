package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.repos.AlbumCrud;
import com.example.songr.models.Song;
import com.example.songr.repos.SongCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongControl {

    @Autowired

    SongCrud songCrud;
    AlbumCrud albumCrud;


//@GetMapping ("/songs/{id}")
//public String getSpecificAlbums(Model model ,@PathVariable long id){
//    Album album =  albumCrud.findById(id).get();
//    model.addAttribute("album",album);
//    return "songs";
//
//}

    @PostMapping("/addsong/{id}")
    public String addSongToDB(Model model , @PathVariable long id,
                              @RequestParam(value="title")String title,
                              @RequestParam(value="length")int length,
                              @RequestParam(value="trackNumber")int trackNumber)
    {


            Album album = albumCrud.findById(id).get();

            Song song = new Song(title, length,trackNumber,album);
            songCrud.save(song);
            model.addAttribute("albums", song);
        return "test";

    }


}

