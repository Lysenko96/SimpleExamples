package com.example.webflux.route;

import com.example.webflux.model.Task;
import com.example.webflux.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.noContent;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;

@Configuration
public class WebFluxConfig {

    private TaskRepository taskRepository;

    public WebFluxConfig(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return route(GET("/task_router"), request -> findAllTasks())
                .andRoute(GET("/task_router/{tag}"), this::findTaskByTag)
                .andRoute(POST("/task_router"), this::saveTask)
                .andRoute(DELETE("/task_router/{tag}"), this::deleteTaskByTag);
    }

    private Mono<ServerResponse> findAllTasks(){
        return ServerResponse.ok().body(taskRepository.findAll(), Task.class);
    }

    private Mono<ServerResponse> findTaskByTag(ServerRequest request){
        return ServerResponse.ok().body(taskRepository.findTaskByTag(request.pathVariable("tag")), Task.class);
    }

    private Mono<ServerResponse> saveTask(ServerRequest request){
        Mono<Task> taskMono = request.bodyToMono(Task.class);
        Mono<Task> taskMonoSave = taskRepository.saveAll(taskMono).next();
        return ServerResponse.ok().body(taskMonoSave, Task.class);
    }

    private Mono<ServerResponse> deleteTaskByTag(ServerRequest request){
        return taskRepository.findTaskByTag(request.pathVariable("tag"))
                .flatMap(task -> noContent().build(taskRepository.delete(task))
                        .switchIfEmpty(notFound().build()));
    }
}
