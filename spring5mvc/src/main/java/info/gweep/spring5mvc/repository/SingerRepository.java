package info.gweep.spring5mvc.repository;

import info.gweep.spring5mvc.entity.Singer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends PagingAndSortingRepository<Singer, Long> {
}
