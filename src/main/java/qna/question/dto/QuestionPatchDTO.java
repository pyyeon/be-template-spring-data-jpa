package qna.question.dto;

import qna.question.entity.Question;
import com.springboot.validator.NotSpace;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.Positive;

@Getter
public class QuestionPatchDTO {

    @Setter
    private Long questionId;

    @NotSpace(message = "제목은 공백이 아니어야 합니다")
    private String title;

    @NotSpace(message = "내용은 공백이 아니어야 합니다")
    private String content;

    private Question.QuestionStatus questionStatus;
}
