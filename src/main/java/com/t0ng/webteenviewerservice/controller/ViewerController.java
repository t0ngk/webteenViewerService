package com.t0ng.webteenviewerservice.controller;

import com.t0ng.webteenviewerservice.db.HistoryRepository;
import com.t0ng.webteenviewerservice.entity.BookOnlyViewerEntity;
import com.t0ng.webteenviewerservice.entity.BookViewerEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/viewer")
public class ViewerController {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/{id}")
    public ResponseEntity<?> getViewerByBookId(@PathVariable String id, @RequestHeader("userId") String userId) {
        System.out.println("User ID: " + userId);
        return ResponseEntity.ok((List<BookViewerEntity>) rabbitTemplate.convertSendAndReceive("Direct", "viewerBook", id));
    }

    @GetMapping("/")
    public List<BookOnlyViewerEntity> getViewerAll() {
        return ((List<BookOnlyViewerEntity>) rabbitTemplate.convertSendAndReceive("Direct","viewerAll",""));
    }
}
