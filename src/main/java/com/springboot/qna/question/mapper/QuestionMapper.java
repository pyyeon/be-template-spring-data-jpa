package com.springboot.qna.question.mapper;

import com.springboot.qna.question.dto.QuestionPatchDTO;
import com.springboot.qna.question.dto.QuestionResponseDTO;
import com.springboot.qna.question.entity.Question;
import com.springboot.qna.question.dto.QuestionPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "memberId", target = "member.memberId")
    Question questionPostDTOToQuestion(QuestionPostDTO questionPostDTO);


    Question questionPatchDTOToQuestion(QuestionPatchDTO questionPatchDTO);

   QuestionResponseDTO questionToQuestionResponseDTO(Question question);

    List<QuestionResponseDTO> questionsToResponseDTOs(List<Question> questions);
}