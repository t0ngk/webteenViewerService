package com.t0ng.webteenviewerservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookOnlyViewerEntity implements Serializable {
    private String _id;
    private int viewer;
}
