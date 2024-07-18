package com.springboot.qna.question.mapper;

import com.springboot.qna.question.dto.LikeDTO;
import com.springboot.qna.question.dto.QuestionPatchDTO;
import com.springboot.qna.question.dto.QuestionResponseDTO;
import com.springboot.qna.question.entity.Like;
import com.springboot.qna.question.entity.Question;
import com.springboot.qna.question.dto.QuestionPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "memberId", target = "member.memberId")
    Question questionPostDTOToQuestion(QuestionPostDTO questionPostDTO);


    @Mapping(source = "questionId", target = "question.questionId")
    @Mapping(source = "memberId", target = "member.memberId")
    Like likeDTOToLike(LikeDTO likeDTO);


    Question questionPatchDTOToQuestion(QuestionPatchDTO questionPatchDTO);

    @Mapping(source = "member.memberId", target = "memberId")
    default QuestionResponseDTO questionToQuestionResponseDTO(Question question) {
        // likes > 라이크 카운트 = likes.size로 몇개인지 매핑
        QuestionResponseDTO responseDTO;

        responseDTO = QuestionResponseDTO.builder()
                .questionId(question.getQuestionId())
                .memberId(question.getMember().getMemberId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(question.getCreatedAt())
                .modifiedAt(question.getModifiedAt())
                .status(question.getStatus())
                .likeCount(question.getLikes().size())
                .viewCount(question.getViews().size())
                .build();

        return responseDTO;

        //조회수도 마찬가지
    }

    List<QuestionResponseDTO> questionsToResponseDTOs(List<Question> questions);


}