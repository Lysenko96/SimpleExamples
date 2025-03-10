package ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CashRegisterReport;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CashRegisterReportPk;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface CashRegisterReportRepository<E> extends JpaRepository<CashRegisterReport, CashRegisterReportPk>, GenericRepository<E> {

    @Query("FROM CashRegisterReport c WHERE c.reportTime BETWEEN :dateFrom AND :dateTo")
    List<E> findAllEntityByDateRangeBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    @Query("FROM CashRegisterReport c WHERE c.reportTime >= :dateFrom")
    List<E> findAllEntityByDateRangeGreaterThanEqual(ZonedDateTime dateFrom);

    @Query("FROM CashRegisterReport c WHERE c.reportTime <= :dateTo")
    List<E> findAllEntityByDateRangeLessThanEqual(ZonedDateTime dateTo);

}


