package com.t0ng.webteenviewerservice.service;

import com.t0ng.webteenviewerservice.db.HistoryRepository;
import com.t0ng.webteenviewerservice.entity.BookOnlyViewerEntity;
import com.t0ng.webteenviewerservice.entity.BookViewerEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewerService {
    @Autowired
    private HistoryRepository historyRepository;

    @RabbitListener(queues = "viewerBookQueue")
    public List<BookViewerEntity> getViewerByBookId(String bookId){
        return historyRepository.findViewerByBookId(bookId);
    }

    @RabbitListener(queues = "viewerAllQueue")
    public List<BookOnlyViewerEntity> getViewerAll(){
        return historyRepository.findViewerAll();
    }
}
