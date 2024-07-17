package com.springboot.qna.answer.mapper;

import com.springboot.qna.answer.dto.AnswerPatchDTO;
import com.springboot.qna.answer.dto.AnswerPostDTO;
import com.springboot.qna.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    //source 원본,출발 target 도착,대상

    @Mapping(source = "questionId", target = "question.questionId")
    public Answer answerPatchDTOToAnswer(AnswerPatchDTO answerPatchDTO);

//    @Mapping(source = "questionId", target = "question.questionId")
    public Answer answerPostDTOToAnswer(AnswerPostDTO answerPostDTO);

    public Answer answerToAnswerResponseDTO(Answer answer);
}
