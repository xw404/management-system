package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Author 小吴
 * @Date 2023/03/21 23:25
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
