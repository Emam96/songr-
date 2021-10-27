package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;



import java.util.Locale;
@Controller
public class ControlPanel {

    @Autowired

    SongCrud songCrud;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String splash(){

        return "songr";
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
