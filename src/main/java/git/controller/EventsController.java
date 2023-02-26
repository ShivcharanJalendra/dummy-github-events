package git.controller;


import git.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventsController {

    @Autowired
    EventsService eventsService;

    @GetMapping("/commits/{owner}/{repo}")
    public ResponseEntity<String> getCommits(@PathVariable String owner, @PathVariable String repo){
        return new ResponseEntity<>(eventsService.getPostsPlainJSON(owner,repo), HttpStatus.OK);
    }
}
