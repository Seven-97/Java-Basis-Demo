package com.seven.javabasis.basicknowledge.stringtest;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @author Seven
 */
public class StringTest {

    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException {
        String str = "abcdef";
        System.out.println("修改前的地址值：" + str + ",hash值" + str.hashCode());
        Class<? extends String> aClass = str.getClass();
        Field value = aClass.getDeclaredField("value");
        value.setAccessible(true);
        value.set(str, "seven".getBytes());
        System.out.println("修改后的地址值：" + str + ",hash值" + str.hashCode());
    }

    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder();
        System.out.println("初始容量：" + sb.capacity());
        sb.append("十五个十五个十五个十五个十五个");
        System.out.println("追加15个字后sb容量：" + sb.capacity());
        sb.append("一");
        System.out.println("已经十六个字SB容量：" + sb.capacity());
        sb.append("添加");
        System.out.println("超过16个字的SB容量：" + sb.capacity());
    }

    @Test
    public void test3() {
        //"a" "b" 被放入串池中，str则存在于堆内存之中
        String str = new String("a") + new String("b");
        //调用str的intern方法，这时串池中没有"ab"，则会将该字符串对象放入到串池中，此时堆内存与串池中的"ab"是同一个对象
        String st2 = str.intern();
        //给str3赋值，因为此时串池中已有"ab"，则直接将串池中的内容返回
        String str3 = "ab";
        //因为堆内存与串池中的"ab"是同一个对象，所以以下两条语句打印的都为true
        System.out.println(str == st2);
        System.out.println(str == str3);
    }

    @Test
    public void test4() {
        //此处创建字符串对象"ab"，因为串池中还没有"ab"，所以将其放入串池中
        String str3 = "ab";
        //"a" "b" 被放入串池中，str则存在于堆内存之中
        String str = new String("a") + new String("b");
        //此时因为在创建str3时，"ab"已存在于串池中，所以放入失败，但是会返回串池中的"ab"
        String str2 = str.intern();
        //false，str在堆内存，str2在串池
        System.out.println(str == str2);
        //false，str在堆内存，str3在串池
        System.out.println(str == str3);
        //true，str2和str3是串池中的同一个对象
        System.out.println(str2 == str3);
    }
}
