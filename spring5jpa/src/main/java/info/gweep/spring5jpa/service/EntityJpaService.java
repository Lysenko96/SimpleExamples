package info.gweep.spring5jpa.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Repository
@Transactional
public class EntityJpaService {


    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManagerFactory() {
        return em;
    }

    public void setEntityManagerFactory(EntityManager em) {
        this.em = em;
    }
}
