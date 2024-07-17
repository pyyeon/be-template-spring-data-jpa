package com.springboot.qna.answer.dto;

import lombok.Setter;

@Setter
public class AnswerPostDTO {
    //사용자로부터 답변 받는 디티오
    private long questionId;
    private String content;

}
