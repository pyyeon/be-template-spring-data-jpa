package com.springboot.qna.answer.controller;

import com.springboot.qna.answer.dto.AnswerPostDTO;
import com.springboot.qna.answer.entity.Answer;
import com.springboot.qna.answer.mapper.AnswerMapper;
import com.springboot.qna.answer.service.AnswerService;
import com.springboot.qna.question.mapper.QuestionMapper;
import com.springboot.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/v11/questions")
@Validated
@Slf4j
public class AnswerController {
    private final static String QUESTION_DEFAULT_URL = "/v11/questions";
    private final AnswerService answerService;
    private  final AnswerMapper mapper;

    public AnswerController(AnswerService answerService, AnswerMapper mapper) {
        this.answerService = answerService;
        this.mapper = mapper;
    }

    @PostMapping("/{question-id}/answer")
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerPostDTO answerPostDTO,
                                     @PathVariable("question-id") long questionId){

        answerPostDTO.setQuestionId(questionId);
        Answer answer = answerService.createAnswer(mapper.answerPostDTOToAnswer(answerPostDTO));
        URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, answer.getAnswerId());
        return ResponseEntity.created(location).build();
    }





}
