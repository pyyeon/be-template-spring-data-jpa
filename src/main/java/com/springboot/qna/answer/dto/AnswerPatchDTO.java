package com.springboot.qna.answer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AnswerPatchDTO {
  @Setter
  private long answerId;

  @Setter
  private Long questionId;



}
