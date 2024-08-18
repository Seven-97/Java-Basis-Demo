package com.seven.javabasis.basicknowledge.bigdecimaltest;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author Seven
 */
@Slf4j
public class BigDecimalEfficiency {

    //执行次数
    public static int REPEAT_TIMES = 10000000;

    // 转BigDecimal 类型计算
    public static double computeByBigDecimal(double a, double b) {
        BigDecimal result = BigDecimal.valueOf(0);
        BigDecimal decimalA = BigDecimal.valueOf(a);
        BigDecimal decimalB = BigDecimal.valueOf(b);
        for (int i = 0; i < REPEAT_TIMES; i++) {
            result = result.add(decimalA.multiply(decimalB));
        }
        return result.doubleValue();
    }

    // 转double 类型计算
    public static double computeByDouble(double a, double b) {
        double result = 0;
        for (int i = 0; i < REPEAT_TIMES; i++) {
            result += a * b;
        }
        return result;
    }

    public static void main(String[] args) {
        long start1 = System.nanoTime();
        double result1 = computeByBigDecimal(0.120001110034, 11.22);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        double result2 = computeByDouble(0.120001110034, 11.22);
        long end2 = System.nanoTime();

        long timeUsed1 = (end1 - start1);
        long timeUsed2 = (end2 - start2);
        log.info("result by BigDecimal:{},time used:{}", result1, timeUsed1);
        log.info("result by Double:{},time used:{}", result2, timeUsed2);
        log.info("timeUsed1/timeUsed2=" + timeUsed1 / timeUsed2);
    }
}
