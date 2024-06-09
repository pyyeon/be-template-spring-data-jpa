package com.springboot.coffee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class Coffee {
    @Id
    private long coffeeId;
}
