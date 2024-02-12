package com.example.demo.repository;

import com.example.demo.dto.NoteDto;
import com.example.demo.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n FROM Note n INNER JOIN FETCH n.person WHERE n.id >= ?1 AND n.id < ?2")
    List<Note> findAllByRange(Long startId, Long endId);

    // work faster when @GetMapping many entries because select only specific fields
    @Query("SELECT new com.example.demo.dto.NoteDto(n.body, p.email) FROM Note n " +
            "INNER JOIN n.person p WHERE n.id >= :startId AND n.id < :endId")
    List<NoteDto> findAllDtoByRange(@Param("startId") Long startId, @Param("endId") Long endId);
}
