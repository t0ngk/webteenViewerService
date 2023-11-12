package com.t0ng.webteenviewerservice.db;

import com.t0ng.webteenviewerservice.entity.BookOnlyViewerEntity;
import com.t0ng.webteenviewerservice.entity.BookViewerEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends MongoRepository<HistoryEntity, String> {
    @Aggregation({
            "{ $match: {bookId: ?0} }",
            "{ $group: { _id: { bookId: '$bookId', chapterId: '$chapterId' }, sum: { $sum: 1 } } }",
            "{ $group: { _id: '$_id.bookId', chapters: { $push: { chapterId: '$_id.chapterId', viewer: '$sum' } }, viewer: { $sum: '$sum' } } }"
    })
    List<BookViewerEntity> findViewerByBookId(String bookId);

    @Aggregation({
            "{ $group: {_id:  '$bookId', viewer: { $sum: 1 }} }"
    })
    List<BookOnlyViewerEntity> findViewerAll();
}
