package com.example.demo.dao;

import com.example.demo.pojo.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FoodDao {

    public List<Food> getAllFood(@Param("start") Integer start, @Param("end") Integer end);
}
