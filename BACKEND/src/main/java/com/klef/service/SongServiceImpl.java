/*package com.klef.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.entity.Song;
import com.klef.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public List<Song> getAllSongs1() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(int id) {
        Optional<Song> opt = songRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Song updateSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void deleteSongById(int id) {
        songRepository.deleteById(id);
    }

	@Override
	public Song addSong(Song song) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> getAllSongs() {
		// TODO Auto-generated method stub
		return null;
		}
	}*/
package com.klef.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.entity.Song;
import com.klef.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(int id) {
        Optional<Song> opt = songRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Song updateSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void deleteSongById(int id) {
        songRepository.deleteById(id);
    }
}

