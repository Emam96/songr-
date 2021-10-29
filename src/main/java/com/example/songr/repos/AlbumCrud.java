package com.example.songr.repos;

import com.example.songr.models.Album;
import org.springframework.data.repository.CrudRepository;
public interface AlbumCrud extends CrudRepository<Album,Long> {
}
