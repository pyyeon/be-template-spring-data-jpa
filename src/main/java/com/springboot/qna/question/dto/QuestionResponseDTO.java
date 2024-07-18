package com.springboot.qna.question.dto;

import com.springboot.qna.question.entity.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Builder
public class QuestionResponseDTO {
    private Long questionId;
    private Long memberId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Question.QuestionStatus status;
    private Question.Visibility visibility;
    private int likeCount;
    private int viewCount;
}
