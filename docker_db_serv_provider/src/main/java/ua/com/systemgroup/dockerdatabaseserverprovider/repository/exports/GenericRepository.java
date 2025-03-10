package ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports;

import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface GenericRepository<E> {

    List<E> findAllEntityByDateRangeBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    List<E> findAllEntityByDateRangeGreaterThanEqual(ZonedDateTime dateFrom);

    List<E> findAllEntityByDateRangeLessThanEqual(ZonedDateTime dateTo);
}
