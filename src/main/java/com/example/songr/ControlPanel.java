package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@Controller
public class ControlPanel {




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String splash(){

        return "songr";
    }



    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public String album(Model model){
        List<Album> data = new ArrayList<>();
        Album album1 = new Album("Blackbird", "Alter bridge","13", "59:17", "https://upload.wikimedia.org/wikipedia/en/1/13/Alterbridge_blackbird.jpg" );
        data.add(album1);
        Album album2 = new Album("Dark Passion Play", "Nightwish","13", "75:36", "https://upload.wikimedia.org/wikipedia/en/5/5e/Dark_Passion_Play.jpg" );
        data.add(album2);
        Album album3 = new Album("Unsung Heroes", "Ensiferum","8", "61:19", "https://upload.wikimedia.org/wikipedia/en/a/a7/Ensiferum_-_Unsung_Heroes.jpg" );
        data.add(album3);
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
