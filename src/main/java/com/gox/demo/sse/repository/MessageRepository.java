package com.gox.demo.sse.repository;

import com.gox.demo.sse.entity.Message;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    private List<Message> messages = new ArrayList();

    public void create(Message msg){
        messages.add(msg);
    }

    public Flux<Message> getAll(){
        return Flux.fromIterable(messages);
    }
}
