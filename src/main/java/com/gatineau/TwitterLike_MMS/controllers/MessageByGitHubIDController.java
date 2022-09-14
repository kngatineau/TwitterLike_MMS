package com.gatineau.TwitterLike_MMS.controllers;


import com.gatineau.TwitterLike_MMS.beans.Message;
import com.gatineau.TwitterLike_MMS.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MessageByGitHubIDController {
    @Autowired
    MessageRepository messageRepo;

    @Autowired
    MongoTemplate mongoTemplate;


    @GetMapping("/messages/user/{github_id}")
    public List<Message> getByGitHubID(@PathVariable String github_id) {
        return messageRepo.findByGitHubID(github_id);
    }


    @GetMapping("/messages/user/{github_id}/desc")
    public List<Message> getByGitHubIDateDesc(@PathVariable String github_id) {
        return messageRepo.findByGitHubIDByDateDesc(github_id);
    }

    @GetMapping("/messages/user/{github_id}/desc/limit")
    public List<Message> getByGitHubIDateDescendingLimit10(@PathVariable String github_id) {
        return messageRepo.findByGitHubIDByDateDescLimit10(github_id);
    }

}

