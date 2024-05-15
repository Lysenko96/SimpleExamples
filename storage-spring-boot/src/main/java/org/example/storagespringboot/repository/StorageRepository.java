package org.example.storagespringboot.repository;

import org.example.storagespringboot.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<ImageData, Long> {
//    @Query("SELECT image FROM ImageData image WHERE image.name = ?1")
    ImageData findByName(String name);
}
