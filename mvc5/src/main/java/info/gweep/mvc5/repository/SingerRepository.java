package info.gweep.mvc5.repository;

import info.gweep.mvc5.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Long> {
}
