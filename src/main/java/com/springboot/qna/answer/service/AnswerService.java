package com.springboot.qna.answer.service;

import com.springboot.qna.answer.entity.Answer;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    public Answer createAnswer(Answer answer){
        return answer;
    }


    public Answer updateAnswer(Answer answer) {
        return answer;
    }

    public void deleteAnswer(long answerId) {
    }
}
