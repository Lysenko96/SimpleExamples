package info.gweep.spring5jpa.service;

import info.gweep.spring5jpa.entity.Album;
import info.gweep.spring5jpa.entity.Singer;
import info.gweep.spring5jpa.repository.AlbumRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("springJpaAlbumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository albumRepository;


    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Album> findByTitle(String title) {
        return albumRepository.findByTitle(title);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Album> findAllBySinger(Singer singer) {
        return albumRepository.findAllBySinger(singer);
    }
}
