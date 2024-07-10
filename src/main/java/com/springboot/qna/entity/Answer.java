package com.springboot.qna.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Answer {
    private Long answerId;



}
