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

import java.util.ArrayList;
import java.util.List;

@Controller
public class SongControl {

    @Autowired

    SongCrud songCrud;
    AlbumCrud albumCrud;


//    @GetMapping("/songs")
//    public  String addAlbum(Model model){
//
//        List<Song> data = (ArrayList<Song>) songCrud.findAll();
//        model.addAttribute("songs", data);
//        return "songs";
//    }






}

