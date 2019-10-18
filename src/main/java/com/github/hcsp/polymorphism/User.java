package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class User {
    /*** 用户ID，数据库主键，全局唯一*/
    private final Integer id;

    /*** 用户名*/
    private final String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // 这里使用了一个NameCollector类，请尝试将它改写成匿名内部类
    // 使得代码更加集中，更加容易阅读


    public static List<String> collectNames(List<User> users) {
        List<String> collectedName = new ArrayList<String>();
        Consumer<User> collector = new Consumer<User>() {
            @Override
            public void accept(User user) {
                collectedName.add(user.getName());
            }
        };
        users.forEach(collector);
        return collectedName;
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User(1, "a"), new User(2, "b"));
        System.out.println(collectNames(users));
    }

//    public static class NameCollector implements Consumer<User> {
//    }
     /*   private final List<String> names = new ArrayList<>();

        @Override
        public void accept(User user) {
            names.add(user.getName());
        }

        public List<String> getNames() {
            return names;
        }
    }*/
}
