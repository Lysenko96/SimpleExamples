package com.example.demo.repository;

import com.example.demo.dto.NoteDto;
import com.example.demo.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Repository
@Transactional
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n FROM Note n JOIN FETCH n.person")
    List<Note> findAllFetchPerson();

    @Query("SELECT new com.example.demo.dto.NoteDto(n.body, p.firstName, n.person.lastName) FROM Note n INNER JOIN n.person p")
    List<NoteDto> findAllDtos();


    Stream<Note> findAllBy();

//     don't work spring 6 need check why?
//    List<NoteDto> findAllBy();
}
