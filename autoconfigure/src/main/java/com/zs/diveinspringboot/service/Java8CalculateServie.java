package com.zs.diveinspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Java 8 lambda 实现 {@link CalculateService}
 */
@Profile("Java8")
@Service
public class Java8CalculateServie implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java 8 lambda 实现");
        int sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }

    public static void main(String[] args) {
        CalculateService calculateService = new Java8CalculateServie();
        System.out.println(calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
