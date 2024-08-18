package com.seven.javabasis.basicknowledge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Seven
 */
public class ArrayTest {
    @Test
    public void test1() {
        Class clz = int[].class;
        System.out.println(clz.getSuperclass().getName());//java.lang.Object
    }

    @Test
    public void test2() {
        int[][] arr = new int[2][];
        System.out.println(arr.getClass().getSuperclass().getName());//java.lang.Object
    }

    @Test
    public void test3() {
        int[] arr = new int[]{1, 2, 3, 4};
//        Arrays.sort(arr, (a, b) -> Integer.compare(b,a));//报错

        arr = Arrays.stream(arr)
                .boxed()
                .sorted((a,b) -> b-a)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(arr));
    }
}
