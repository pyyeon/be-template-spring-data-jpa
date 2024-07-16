package com.springboot.qna.answer.mapper;

import com.springboot.qna.answer.dto.AnswerPatchDTO;
import com.springboot.qna.answer.dto.AnswerPostDTO;
import com.springboot.qna.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(source = "memberId", target = "member.memberId")
    public Answer answerPatchDTOToAnswer(AnswerPatchDTO answerPatchDTO);

    @Mapping(source = "questionId", target = "question.questionId")
    @Mapping(source = "memberId", target = "member.memberId")
    public Answer answerPostDTOToAnswer(AnswerPostDTO answerPostDTO);

    public Answer answerToAnswerResponseDTO(Answer answer);
}
