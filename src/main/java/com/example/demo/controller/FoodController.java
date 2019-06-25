package com.example.demo.controller;

import com.example.demo.pojo.Food;
import com.example.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/getAllFood")
    public List<Food> getAllFood(@RequestParam(defaultValue = "0") String start,
                                 @RequestParam(defaultValue = "2") String end){
        return foodService.getAllFood(start,end);
    }
}
