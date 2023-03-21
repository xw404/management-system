package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 小吴
 * @Date 2023/03/22 16:44
 * @Version 1.0
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
