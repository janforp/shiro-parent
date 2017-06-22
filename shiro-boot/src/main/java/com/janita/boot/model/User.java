package com.janita.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

@JsonIgnoreProperties(value = {"handler"})
public class User {

    private String id;
    private Long version;
    private Long created;
    private String email;
    private String name;
    private Boolean active;
    private String password;
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        if (roles == null) {
            this.roles = new ArrayList<>();
        }
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public static Map<String, User> userMap() {
        User userOne = new User();
        userOne.setId("1");
        userOne.setVersion(1L);
        userOne.setCreated(1111111L);
        userOne.setEmail("janfor@163.com");
        userOne.setName("Janita");
        userOne.setActive(true);
        userOne.setPassword("123456");
        userOne.setRoles(Arrays.asList(Role.teacherRole()));

        User userTwo = new User();
        userTwo.setId("2");
        userTwo.setVersion(1L);
        userTwo.setCreated(1111111L);
        userTwo.setEmail("jan@163.com");
        userTwo.setName("JanitaZZZ");
        userTwo.setActive(true);
        userTwo.setPassword("123456");
        userTwo.setRoles(Arrays.asList(Role.masterRole()));

        Map<String, User> map = new HashMap<>();
        map.put(userOne.getEmail(), userOne);
        map.put(userTwo.getEmail(), userTwo);

        return map;
    }

}
