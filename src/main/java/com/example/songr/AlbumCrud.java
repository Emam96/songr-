package com.example.songr;

import org.springframework.data.repository.CrudRepository;
public interface AlbumCrud extends CrudRepository<Album,Integer> {
}
