package com.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 员工
 */
@Data
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String idNumber;
    private String phone;
    private Integer gender;
    private Position position;
    private Department department;
    private int positionId;
    private int departmentId;

}
