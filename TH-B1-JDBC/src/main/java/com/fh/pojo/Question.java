package com.fh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {
    private String id;
    private String content;
    private int categoryID;
}
