package com.boot.boot.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class User {
    private Integer id;

    private String username;

    private String password;

    private String salt;


    private List<String> list;

    private Map<String,Object> maps;

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", list=" + list +
                ", maps=" + maps +
                '}';
    }

    public User(){}

    public void test22(){
        for (int i = 0; i < 10; i++) {
            System.out.println("------------------");
        }

    }
     @PostConstruct
    public void test33(){
        for (int i = 0; i < 10; i++) {
            System.out.println("------------------22222");
        }

    }

    @PreDestroy
    public void test3344(){
        for (int i = 0; i < 10; i++) {
            System.out.println("------------------3333");
        }
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(list, user.list) &&
                Objects.equals(maps, user.maps);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, salt, list, maps);
    }
}
