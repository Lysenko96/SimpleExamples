package com.example.demowebclient.controller;

import com.example.demowebclient.model.Task;
import com.example.demowebclient.repository.TaskRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Objects;
import java.util.concurrent.*;

@RestController
@RequestMapping(value = "/external", produces = "application/json")
public class TaskController {

    private WebClient webClient;
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // IF TAG NOT UNIQUE FOR REST (GET, POST, DELETE) ERROR

    @PostConstruct
    public void setUpWebClient() {
        this.webClient = WebClient.create("http://localhost:8080");
    }

    @GetMapping("/{tag}")
    public Task getByTag(@PathVariable("tag") String tag) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Task result;
        Mono<Task> taskMono = webClient
                .get()
                .uri("/{tag}", tag)
                .retrieve()
                .bodyToMono(Task.class);
        Future<Task> future = executorService.submit(() -> taskMono.block());
        try {
            result = taskRepository.findTaskByTag(future.get().getTag());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        return result;
    }

    @DeleteMapping("/{tag}/delete")
    public Mono<Void> deleteByTag(@PathVariable("tag") String tag){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Mono<Task> taskMono = webClient
                .delete()
                .uri("/{tag}", tag)
                .retrieve()
                .bodyToMono(Task.class);
        Future<Task> future = executorService.submit(() -> taskMono.block());
        try {
            taskRepository.delete(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        return webClient
                .get()
                .uri("/{tag}", tag)
                .retrieve()
                .bodyToMono(Void.class);
    }

    @PostMapping("/post")
    public Task postTask(@RequestBody Task task){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Task result;
        Mono<Task> taskMono = webClient
                .post()
                .uri("/")
                .body(Mono.just(task), Task.class)
                .exchangeToMono(r -> r.bodyToMono(Task.class));
        Future<Task> future = executorService.submit(() -> taskMono.block());
        try {
            result = taskRepository.save(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        return result;
    }

    @PutMapping("/{tag}/edit")
    public Task editTask(@RequestBody Task task, @PathVariable("tag") String tag){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Task result;
        Mono<Task> taskMono = webClient
                .put()
                .uri("/{tag}", tag)
                .body(Mono.just(task), Task.class)
                .retrieve()
                .bodyToMono(Task.class);
        Future<Task> future = executorService.submit(() -> taskMono.block());
        try {
            result = taskRepository.save(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        return result;
    }

}
