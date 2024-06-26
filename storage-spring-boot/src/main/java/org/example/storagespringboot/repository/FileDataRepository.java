package org.example.storagespringboot.repository;

import org.example.storagespringboot.entity.FileData;
import org.example.storagespringboot.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long> {
    FileData findByName(String name);

}
