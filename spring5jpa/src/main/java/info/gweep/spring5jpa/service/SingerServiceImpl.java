package info.gweep.spring5jpa.service;

import info.gweep.spring5jpa.entity.Album;
import info.gweep.spring5jpa.entity.Instrument;
import info.gweep.spring5jpa.entity.Singer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;

@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {

    private static final String ALL_SINGER = "SELECT * FROM singer";
    private static final String ALL_SINGER_ALBUMS_BY_SINGER_ID = "SELECT * FROM album WHERE singer_id = :singer_id";
    private static final String ALL_SINGER_INSTRUMENTS_BY_SINGER_ID = "SELECT * FROM singer_instrument WHERE singer_id = :singer_id";

    @PersistenceContext
    private EntityManager em;


    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return em.createNamedQuery("Singer.FIND_ALL", Singer.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
        return em.createNamedQuery("Singer.FIND_ALL_WITH_ALBUM", Singer.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        return em.createNamedQuery("Singer.FIND_BY_ID", Singer.class)
                .setParameter("id", id).getSingleResult();
    }

    @Transactional
    @Override
    public Singer save(Singer singer) {
        if(singer.getId() == null) {
            em.persist(singer);
        } else {
            em.merge(singer);
        }
        return em.find(Singer.class, singer.getId());
    }

    @Transactional
    @Override
    public void delete(Singer singer) {
        em.merge(singer);
        em.remove(findById(singer.getId()));
    }

    @Transactional//(readOnly = true)
    @Override
    public List<Singer> findAllByNativeQuery() {
        List<Singer> singers = em.createNativeQuery(ALL_SINGER, Singer.class).getResultList();
        // for fetch = FetchType.LAZY and orphanRemoval = false
        for(Singer singer : singers){
            singer.setAlbums(new HashSet<>(em.createNativeQuery(ALL_SINGER_ALBUMS_BY_SINGER_ID, Album.class).setParameter("singer_id", singer.getId()).getResultList()));
            singer.setInstruments(new HashSet<>(em.createNativeQuery(ALL_SINGER_INSTRUMENTS_BY_SINGER_ID, Instrument.class).setParameter("singer_id", singer.getId()).getResultList()));
        }
        return singers;
    }
}
