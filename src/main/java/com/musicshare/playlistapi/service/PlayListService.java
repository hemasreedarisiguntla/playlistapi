package com.musicshare.playlistapi.service;

import com.musicshare.playlistapi.entity.PlayList;
import com.musicshare.playlistapi.entity.Song;
import com.musicshare.playlistapi.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayListService {

    @Autowired
    PlayListRepository playListRepository;

    public PlayList createPlayListWithName(String name) {

        PlayList playList = PlayList.builder()
                .name(name)
                .songs(new ArrayList<Song>())
                .build();


        return playListRepository.save(playList);
    }

    public PlayList addSongsToPlayList(String playListName, Song song) {
        PlayList playList = playListRepository.findByName(playListName);
        List<Song> songs = new ArrayList();
        songs.add(song);
        playList.setSongs(songs);
        return playListRepository.save(playList);
    }
}
