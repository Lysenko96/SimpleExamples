package ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CashOperation;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CashOperationPk;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface CashOperationRepository<E> extends JpaRepository<CashOperation, CashOperationPk>, GenericRepository<E> {

    @Query("FROM CashOperation c WHERE c.dateOperation BETWEEN :dateFrom AND :dateTo")
    List<E> findAllEntityByDateRangeBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    @Query("FROM CashOperation c WHERE c.dateOperation >= :dateFrom")
    List<E> findAllEntityByDateRangeGreaterThanEqual(ZonedDateTime dateFrom);

    @Query("FROM CashOperation c WHERE c.dateOperation <= :dateTo")
    List<E> findAllEntityByDateRangeLessThanEqual(ZonedDateTime dateTo);
}
