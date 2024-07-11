package qna.question.mapper;

import qna.question.dto.QuestionPatchDTO;
import qna.question.dto.QuestionPostDTO;
import qna.question.entity.Question;
import org.mapstruct.Mapper;import qna.question.dto.QuestionPatchDTO;import qna.question.entity.Question;

import java.util.List;
@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Object questionPostDTOToQuestion(QuestionPostDTO questionPostDTO);


    Object questionPatchDTOToQuestion(QuestionPatchDTO questionPatchDTO);

   Object questionToQuestionResponseDTO(Question question);

    List<Object> questionsToResponseDTOs(List<Question> questions);
}
