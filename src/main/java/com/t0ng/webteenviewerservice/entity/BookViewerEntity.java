package com.t0ng.webteenviewerservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BookViewerEntity implements Serializable {
    private String _id;
    private List<ChapterViewerEntity> chapters;
    private int viewer;
}
