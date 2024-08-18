package com.seven.javabasis.basicknowledge.objecttest;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Seven
 */
public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    public static void main(String[] args) {
        Person p1 = new Person("123");
        Person p2 = new Person("123");

        System.out.println(p1 == p2);//false
        System.out.println(p1.hashCode() == p2.hashCode());//false
        System.out.println(p1.equals(p2));//true

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println(set.size());//2
    }
}
