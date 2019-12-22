package com.example.builderdemo;

/**
 * @author xukai
 * @date 2019/12/4
 */
public class User {
    private Integer id;
    private String name;
    private String address;

    private User() {
    }

    public User(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String address;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(id, name, address);
        }
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            '}';
    }
}
