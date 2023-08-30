package com.example.springdownloadfile.repository;

import com.example.springdownloadfile.entity.File;
import org.springframework.data.repository.CrudRepository;

public interface FileRepo extends CrudRepository<File, Long> {
}
