package info.gweep.spring5jpa.repository;

import info.gweep.spring5jpa.entity.Album;
import info.gweep.spring5jpa.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT a FROM Album a WHERE a.title LIKE %:title%")
    List<Album> findByTitle(@Param("title") String text);

    List<Album> findAllBySinger(Singer singer);
}
