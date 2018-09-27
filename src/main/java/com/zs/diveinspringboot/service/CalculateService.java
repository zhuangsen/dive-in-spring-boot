package com.zs.diveinspringboot.service;

public interface CalculateService {

    /**
     * 从多个整数sum求和
     * @param values 多个整数
     * @return sum 累加值
     */
    Integer sum(Integer ...values);
}
