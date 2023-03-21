package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author 小吴
 * @Date 2023/03/22 16:42
 * @Version 1.0
 */
@Data
@TableName("admin")
public class Admin {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String adminUser;
    private String adminPassword;
}
