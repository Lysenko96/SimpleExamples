package info.gweep.spring5jpa.service;

import info.gweep.spring5jpa.entity.Album;
import info.gweep.spring5jpa.entity.Singer;

import java.util.List;

public interface AlbumService {

    List<Album> findByTitle(String title);
    List<Album> findAllBySinger(Singer singer);
}
