package com.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String name;

    private Integer role;

    private Integer status;

    private String roleName;

    public String getRoleName() {
        return role == 1 ? "管理员" : "普通用户";
    }
}
