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
public class ControlPanel {

    @Autowired
AlbumCrud albumCrud;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String splash(){

        return "songr";
    }



    @GetMapping("/album")

    public RedirectView addAlbum(){
        Album album1 = new Album("Blackbird", "Alter bridge","13", "59:17", "https://upload.wikimedia.org/wikipedia/en/1/13/Alterbridge_blackbird.jpg" );
        albumCrud.save(album1);
        Album album2 = new Album("Dark Passion Play", "Nightwish","13", "75:36", "https://upload.wikimedia.org/wikipedia/en/5/5e/Dark_Passion_Play.jpg" );
        albumCrud.save(album2);
        Album album3 = new Album("Unsung Heroes", "Ensiferum","8", "61:19", "https://upload.wikimedia.org/wikipedia/en/a/a7/Ensiferum_-_Unsung_Heroes.jpg");
        albumCrud.save(album3);

        return new RedirectView("/allalbums");
    }

    @GetMapping("/allalbums")
    public String getAllAlbums(Model model){
        List<Album> data = (ArrayList<Album>) albumCrud.findAll();
        model.addAttribute("albums", data);
        return "album";
    }







    @GetMapping("/hello")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }


    @GetMapping("/capitalize/{input}")
    @ResponseBody
    public String capitalizer(@PathVariable String input){
        return input.toUpperCase(Locale.ROOT);
    }



}
