package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Animal;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 小吴
 * @Date 2023/03/22 20:06
 * @Version 1.0
 */
@Mapper
public interface AnimalMapper extends BaseMapper<Animal>{
}
