package org.example.mvcapp.controller;

import org.example.mvcapp.dto.Message;
import org.example.mvcapp.exception.MessageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/messages")
public class MessageRestController {

    private AtomicLong atomicId = new AtomicLong();
    private Map<Long, Message> messageMap = new ConcurrentHashMap<>();

    @PostMapping
    //public void addMessage(@RequestBody Message message){
    public ResponseEntity<Message> addMessage(RequestEntity<Message> messageRequestEntity){
        Message message = buildMessage(Objects.requireNonNull(messageRequestEntity.getBody()));
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public Collection<Message> getMessages(){
        return messageMap.values();
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable("id") Long id) throws MessageNotFoundException {
        return Optional.ofNullable(messageMap.get(id))
                .orElseThrow(() -> new MessageNotFoundException("Cannot find message by id: " + id));
    }

    private Message buildMessage(Message message){
        message.setId(atomicId.incrementAndGet());
        messageMap.put(message.getId(), message);
        return message;
    }
}
