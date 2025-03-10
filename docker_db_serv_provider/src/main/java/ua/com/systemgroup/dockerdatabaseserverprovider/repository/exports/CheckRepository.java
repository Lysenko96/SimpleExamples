package ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.Check;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CheckPk;

import java.util.Date;
import java.util.List;

@Repository
public interface CheckRepository extends JpaRepository<Check, CheckPk> {

    @Query("FROM Check c WHERE c.dateOperation BETWEEN :dateFrom AND :dateTo")
    List<Check> findCheckByDateOperationBetween(Date dateFrom, Date dateTo);

    @Query("FROM Check c WHERE c.dateOperation >= :dateFrom")
    List<Check> findCheckByDateOperationGreaterThanEqual(Date dateFrom);

    @Query("FROM Check c WHERE c.dateOperation <= :dateTo")
    List<Check> findCheckByDateOperationLessThanEqual(Date dateTo);
}
