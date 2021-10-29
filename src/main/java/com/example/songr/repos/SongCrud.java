package com.example.songr.repos;

import com.example.songr.models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongCrud extends CrudRepository<Song, Long> {


}
