package com.gatineau.TwitterLike_MMS.controllers;


import com.gatineau.TwitterLike_MMS.beans.Message;
import com.gatineau.TwitterLike_MMS.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController

public class MessageController {
    @Autowired
    MessageRepository messageRepo;

    @Autowired
    MongoTemplate mongoTemplate;


    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        return new ResponseEntity<>(messageRepo.findAll(), HttpStatus.OK);
    }

    private void createMessage() {
        try {
            Message message = messageRepo.save(new Message(
                    "kngatineau",
                    "Test Title",
                    "SPAMMY SPAM SPAM.",
                    new Date()));
            new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
