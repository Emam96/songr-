package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@Controller
public class SongControl {

    @Autowired

    SongCrud songCrud;


    @GetMapping("/albumsongs")

    public RedirectView addSong(){
        Song song1 = new Song("ties that bind", "5:10",1);
        songCrud.save(song1);
        Song song2 = new Song("come to life", "5:10",2);
        songCrud.save(song2);
        return new RedirectView("/albumsong");
    }


    @GetMapping("/albumsong")
    public String getAlbumSongs(Model model){
        List<Song> data = (ArrayList<Song>) songCrud.findAll();
        model.addAttribute("songs", data);
        return "albumsongs";
    }


    @PostMapping("/albumsongs")
    public RedirectView addAlbumToDB(Model model, @RequestParam(value="title") String title, @RequestParam(value="trackNumber") int trackNumber,  @RequestParam(value="length") String length){
        Song song = new Song(title,length,trackNumber);
        songCrud.save(song);
        return new RedirectView("/albumsongs");
    }


}

