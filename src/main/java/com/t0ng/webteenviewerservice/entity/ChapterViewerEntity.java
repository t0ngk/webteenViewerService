package com.t0ng.webteenviewerservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChapterViewerEntity implements Serializable {
    private String chapterId;
    private int viewer;
}
