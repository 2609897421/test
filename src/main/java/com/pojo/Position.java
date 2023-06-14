package com.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 职位
 */
@Data
public class Position implements Serializable {
    private Integer id;
    private String name;
}
