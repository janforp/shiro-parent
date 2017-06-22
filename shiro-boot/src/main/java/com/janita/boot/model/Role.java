package com.janita.boot.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Role {

    private String id;
    private Long version;
    private String name;
    private String description;
    private List<Permission> permissions;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Permission> getPermissions() {
        if (permissions == null)
            this.permissions = new ArrayList<>();
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * 老师只有添加跟查询的权限
     * @return
     */
    public static Role teacherRole() {
        Role teacher = new Role();
        teacher.setId("teacherOne");
        teacher.setVersion(1L);
        teacher.setName("teacher");
        teacher.setDescription("老师角色");
        teacher.setPermissions(Arrays.asList(Permission.create(), Permission.find()));
        return teacher;
    }

    /**
     * 校长有所有权限
     * @return
     */
    public static Role masterRole() {
        Role master = new Role();
        master.setId("master");
        master.setVersion(1L);
        master.setName("master");
        master.setDescription("校长角色");
        master.setPermissions(Arrays.asList(Permission.create(), Permission.find(), Permission.deletePermission(), Permission.update()));
        return master;
    }


}
