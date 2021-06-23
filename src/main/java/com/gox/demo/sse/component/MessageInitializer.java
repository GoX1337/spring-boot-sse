package com.gox.demo.sse.component;

import com.gox.demo.sse.entity.Message;
import com.gox.demo.sse.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class MessageInitializer implements CommandLineRunner {

    private int id = 0;

    @Autowired
    private MessageRepository msgRepo;

    @Override
    public void run(String... args) {
        for(int i = 0; i < 3; i++) {
            msgRepo.create(new Message(id++, "Hi " + id, new Random().nextInt(), new Date()));
        }
    }
}