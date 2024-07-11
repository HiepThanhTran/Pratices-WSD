package com.fh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Choice {
    private String id;
    private String content;
    private boolean isCorrect;
    private String questionID;
}
