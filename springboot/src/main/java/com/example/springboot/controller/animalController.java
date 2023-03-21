package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Animal;
import com.example.springboot.mapper.AnimalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author 小吴
 * @Date 2023/03/21 23:17
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/animal")
public class animalController {

    @Autowired
    private AnimalMapper animalMapper;
    /**
     * 新增
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Animal animal){
        animalMapper.insert(animal);
        return Result.success();
    }

    /**
     * 更新修改
     * @param animal
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Animal animal){
        animalMapper.updateById(animal);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        animalMapper.deleteById(id);
        return Result.success();
    }
    /**
     * 列表分页
     * @param pageNum
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Animal> wrapper = Wrappers.<Animal>lambdaQuery();
        if(StringUtils.isNotBlank(search)){
            wrapper.like(Animal::getName,search);
        }
        Page<Animal> animalPage = animalMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(animalPage);
    }
}
