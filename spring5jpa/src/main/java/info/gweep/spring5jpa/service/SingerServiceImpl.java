package info.gweep.spring5jpa.service;

import info.gweep.spring5jpa.entity.Singer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;

@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {

    private static final String ALL_SINGER_NATIVE_QUERY = "SELECT * FROM singer";

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

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_SINGER_NATIVE_QUERY, Singer.class).getResultList();
    }
}
