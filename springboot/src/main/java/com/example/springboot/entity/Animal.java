package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @Author 小吴
 * @Date 2023/03/22 20:02
 * @Version 1.0
 */
@Data
@TableName("animal")
public class Animal {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String love;
    private String kind;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Integer createTime;
    private String picture;

}
