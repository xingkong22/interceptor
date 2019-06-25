package com.example.demo.service.impl;

import com.example.demo.dao.FoodDao;
import com.example.demo.pojo.Food;
import com.example.demo.service.FoodService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodDao foodDao;

    @Override
    public List<Food> getAllFood(@Param("start") String start, @Param("end") String end) {
        return foodDao.getAllFood(Integer.parseInt(start), Integer.parseInt(end));
    }
}
