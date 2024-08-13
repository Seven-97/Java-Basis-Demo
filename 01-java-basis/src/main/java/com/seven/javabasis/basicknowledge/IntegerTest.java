package com.seven.javabasis.basicknowledge;

import org.junit.jupiter.api.Test;

/**
 * @author Seven
 * https://www.seven97.top/java/basis/01-basic-knowledge.html#integer缓存池
 */
public class IntegerTest {

    @Test
    public void test1() {
        Integer a = 100;

        Integer b = 100;
        System.out.println(a == b);

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d);
    }

    @Test
    public void test2() {
        System.out.println(Integer.valueOf(-128) == Integer.valueOf(-128));//1.true
        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));//2.true
        System.out.println(Integer.valueOf(128) == Integer.valueOf(128));//3.false
        System.out.println(Integer.parseInt("128") == Integer.valueOf(128));//4.true

    }
}
