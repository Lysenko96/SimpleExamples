package com.example.webflux.controller;

import com.example.webflux.model.Task;
import com.example.webflux.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public Flux<Task> index(){
        return taskRepository.findAll();
    }

    @GetMapping("/{tag}")
    public Mono<Task> findTaskByTag(@PathVariable("tag") String tag){
        return taskRepository.findTaskByTag(tag);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Task> create (@RequestBody Mono<Task> task){
        return taskRepository.saveAll(task).next();
    }

    @DeleteMapping("/{tag}")
    public Mono<ResponseEntity<Void>> deleteByTag(@PathVariable("tag") String tag){
        return taskRepository.findTaskByTag(tag)
                .flatMap(task -> taskRepository.delete(task))
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
