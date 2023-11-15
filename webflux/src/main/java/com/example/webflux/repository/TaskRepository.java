package com.example.webflux.repository;

import com.example.webflux.model.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TaskRepository extends ReactiveMongoRepository<Task, String> {

    Mono<Task> findTaskByTag(String tag);
}
