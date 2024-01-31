package com.playerweb.playerweb.model;

import com.playerweb.playerweb.music.Music;

import java.util.List;

public interface JDBCController {
    void createSchema();

    void createTable();

    void addMusic(Music music);

    List<Music> getMusics();
}
