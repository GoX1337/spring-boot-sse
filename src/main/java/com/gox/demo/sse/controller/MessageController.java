package com.gox.demo.sse.controller;

import com.gox.demo.sse.entity.Message;
import com.gox.demo.sse.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.Date;
import java.util.Random;

@RestController
public class MessageController {

    final Sinks.Many sink;
    int id = 0;

    @Autowired
    private MessageRepository msgRepo;

    public MessageController() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    @GetMapping("/send")
    public void test() {
        Sinks.EmitResult result = sink.tryEmitNext(new Message(id++, "Hi " + id, new Random().nextInt(), new Date()));
        System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        if (result.isFailure()) {
            // do something here, since emission failed
        }
    }

    @CrossOrigin(allowedHeaders = "*")
    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getResourceUsage() {
        System.out.println("/events");
        return sink.asFlux();
    }
}
