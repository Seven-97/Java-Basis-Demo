package com.seven.javabasis.basicknowledge;

import org.junit.jupiter.api.Test;

/**
 * @author Seven
 * https://www.seven97.top/java/basis/01-basic-knowledge.html#bigdecimal
 */
public class BigDecimalTest {
    @Test
    public void test1() {
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999905
        System.out.println(a == b);// false
    }



}
