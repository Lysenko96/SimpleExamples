package ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.ShiftWork;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.ShiftWorkPk;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface ShiftWorkRepository<E> extends JpaRepository<ShiftWork, ShiftWorkPk>, GenericRepository<E> {

    @Query("FROM ShiftWork s WHERE s.dateShift BETWEEN :dateFrom AND :dateTo")
    List<E> findAllEntityByDateRangeBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    @Query("FROM ShiftWork s WHERE s.dateShift >= :dateFrom")
    List<E> findAllEntityByDateRangeGreaterThanEqual(ZonedDateTime dateFrom);

    @Query("FROM ShiftWork s WHERE s.dateShift <= :dateTo")
    List<E> findAllEntityByDateRangeLessThanEqual(ZonedDateTime dateTo);
}
