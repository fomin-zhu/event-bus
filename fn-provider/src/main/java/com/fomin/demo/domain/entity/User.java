package com.fomin.demo.domain.entity;

/**
 * @author fomin
 * @since 2020/6/30
 */
public class User {
    private String name;
    private int age;

    public User() {
        
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
