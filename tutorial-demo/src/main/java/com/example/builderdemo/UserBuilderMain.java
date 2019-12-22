package com.example.builderdemo;

/**
 * 学习使用Build构造方法
 * @author xukai
 * @date 2019/12/4
 */
public class UserBuilderMain {
    public static void main(String[] argv) {
        // 静态方法构造器
        User user = User.builder()
            .setId(123)
            .setName("xukai")
            .build();
        System.out.println(user.toString());


        // 使用一个UserFactory
        User myUser =  new UserFactory().setId(12).setAddress("test").setName("xukai").build();
        System.out.println(myUser.toString());
    }
}
