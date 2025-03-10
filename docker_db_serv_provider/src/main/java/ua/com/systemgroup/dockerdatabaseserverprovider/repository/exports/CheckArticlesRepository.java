package ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CheckArticles;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CheckArticlesPk;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface CheckArticlesRepository<E> extends JpaRepository<CheckArticles, CheckArticlesPk>, GenericRepository<E> {

    @Query("FROM CheckArticles c WHERE c.timeAdd BETWEEN :dateFrom AND :dateTo")
    List<E> findAllEntityByDateRangeBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    @Query("FROM CheckArticles c WHERE c.timeAdd >= :dateFrom")
    List<E> findAllEntityByDateRangeGreaterThanEqual(ZonedDateTime dateFrom);

    @Query("FROM CheckArticles c WHERE c.timeAdd <= :dateTo")
    List<E> findAllEntityByDateRangeLessThanEqual(ZonedDateTime dateTo);
}
