package com.springboot.qna.question.service;

import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.member.service.MemberService;
import com.springboot.qna.question.entity.Question;
import com.springboot.qna.question.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final MemberService memberService;

    public QuestionService(QuestionRepository questionRepository, MemberService memberService) {
        this.questionRepository = questionRepository;
        this.memberService = memberService;
    }


    public Question createQuestion(Question question) {
        memberService.findVerifiedMember(question.getMember().getMemberId());
        return questionRepository.save(question);

    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Question updateQuestion(Question question) {

        Question findQuestion = findQuestion(question.getQuestionId());

        Optional.ofNullable(question.getTitle())
                .ifPresent(title -> findQuestion.setTitle(title));
        Optional.ofNullable(question.getContent())
                .ifPresent(content -> findQuestion.setContent(content));
        Optional.ofNullable(question.getStatus())
                .ifPresent(questionStatus -> findQuestion.setStatus(questionStatus));
        Optional.ofNullable(question.getVisibility())
                .ifPresent(visibility -> findQuestion.setVisibility(visibility));
        findQuestion.setModifiedAt(LocalDateTime.now());
        return questionRepository.save(question);
    }

    public Question findQuestion(long questionId) {

        return findVerifiedQuestion(questionId);

    }

    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size, Sort.by("questionId").descending()));
    }

    public void deleteQuestion(long questionId) {
        Question findQuestion = findVerifiedQuestion(questionId);
       int step = findQuestion.getStatus().getStepNumber();

       if(step >= 2){
           throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_QUESTION);
       }
       findQuestion.setStatus(Question.QuestionStatus.QUESTION_DELETED);
       findQuestion.setModifiedAt(LocalDateTime.now());

       questionRepository.save(findQuestion);
    }

    public Question findVerifiedQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        return optionalQuestion.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
    }

    public void isExistQuestion() {

    }


    public void isPublic() {

    }


}
