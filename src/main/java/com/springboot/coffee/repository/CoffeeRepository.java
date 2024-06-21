package com.springboot.coffee.repository;

import com.springboot.coffee.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Optional<Coffee> findByCoffeeCode(String coffeeCode);

    @Query(value = "SELECT c FROM COFFEE c WHERE c.coffeeId = : coffeeId")
    Optional<Coffee> findByCoffee(long coffeeId);
}
