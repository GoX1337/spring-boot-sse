package com.gox.demo.sse.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gox.demo.sse.entity.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class MessageController {

    private int id = 0;
    private ObjectMapper mapper = new ObjectMapper();
    private List<Message> messages = new ArrayList();

    @CrossOrigin(allowedHeaders = "*")
    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getResourceUsage() {
        return Flux
                .fromIterable(messages)
                .map(it -> {
                    Message msg = new Message(id++, "Hi " + id, new Random().nextInt(), new Date());
                    messages.add(msg);
                    return msg;
                })
                .map(message -> {
                    try {
                        String m = mapper.writeValueAsString(message);
                        System.out.println("event sent: " + m);
                        return m;
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }
}
