package com.example.demowebclient.repository;

import com.example.demowebclient.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findTaskByTag(String tag);
}
