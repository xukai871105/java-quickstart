package com.example.builderdemo;

/**
 * @author xukai
 * @date 2019/12/4
 */
public class UserFactory {
    private Integer id;
    private String name;
    private String address;

    public UserFactory setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserFactory setName(String name) {
        this.name = name;
        return this;
    }

    public UserFactory setAddress(String address) {
        this.address = address;
        return this;
    }

    public User build() {
        return new User(id, name, address);
    }
}
