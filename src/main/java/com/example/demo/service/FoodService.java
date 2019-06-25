package com.example.demo.service;

import com.example.demo.dao.FoodDao;
import com.example.demo.pojo.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {

    public List<Food> getAllFood(@Param("start") String start, @Param("end") String end);
}
