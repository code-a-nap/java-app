package com.vulnerable.application.model;

import java.io.Serializable;

public abstract class GenericUser implements Serializable {
    static final long serialVersionUID = 1337L;

    private String username;
    private Integer age;
    private Boolean isAdmin;
    private String flag;

    public GenericUser() {

    }

    public GenericUser(String username, Integer age, Boolean isAdmin, String flag) {
        this.username = username;
        this.age = age;
        this.isAdmin = isAdmin;
        this.flag = flag;
    }

    public Boolean isIsAdmin() {
        return this.isAdmin;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}
