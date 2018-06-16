package com.test.java;

/**
 * Created by yjq14 on 2018/6/14.
 */
public final class Person {
    public Person(String name) {
        System.out.println(name);
    }
    public Person() {}
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static String getPersonName() {
        return "yang";
    }
}
