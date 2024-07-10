package com.springboot.qna.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionPostDTO {
    private String title;
    private String content;
    private String visibility;
}
