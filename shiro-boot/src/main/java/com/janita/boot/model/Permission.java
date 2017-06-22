package com.janita.boot.model;


public class Permission {

    private String id;
    private Long version;
    private String name;
    private String description;

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

    public static Permission create() {
        Permission permission = new Permission();
        permission.setId("create");
        permission.setVersion(111111111111L);
        permission.setName("添加");
        permission.setDescription("添加资源");

        return permission;
    }

    public static Permission deletePermission() {
        Permission permission = new Permission();
        permission.setId("delete");
        permission.setVersion(111111111111L);
        permission.setName("删除");
        permission.setDescription("删除资源");

        return permission;
    }

    public static Permission update() {
        Permission permission = new Permission();
        permission.setId("update");
        permission.setVersion(111111111111L);
        permission.setName("修改");
        permission.setDescription("修改资源");

        return permission;
    }

    public static Permission find() {
        Permission permission = new Permission();
        permission.setId("find");
        permission.setVersion(111111111111L);
        permission.setName("查询");
        permission.setDescription("查询资源");

        return permission;
    }

}
