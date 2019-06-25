package com.example.demo.controller;

import com.example.demo.common.YZToken;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Demo {
    private static final String name = "token";

    @RequestMapping(value = "/index")
    public String jump(HttpServletRequest request, Model model){
        /*Boolean flag = YZToken.yanZToken(request, name);
        if(!flag){
            System.out.println("没有");
            return "login";
        }*/
        List<User> list = new ArrayList<>();
        list.add(new User("张三1", "男",22));
        list.add(new User("张四1", "女",22));
        list.add(new User("张五1", "男",22));

        model.addAttribute("name", new User("张三2", "男2",22));
        model.addAttribute("age",new User("张四2", "女2",22));
        model.addAttribute("list",list);


        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginAfter")
    public String loginAfter(HttpServletRequest request, HttpServletResponse response, @RequestParam String flag){
        if(flag.equals("1")){
            YZToken.setCookie(request, response,name,"",60*2);
            try {
                response.sendRedirect("index");
            }catch (Exception e){
                return "服务异常";
            }
            return "";
        }else{
            return "";
        }

    }

    @ResponseBody
    @GetMapping(value = "/getMesg")
    public Map<String, Object> getMesg(){
        Map<String, Object> map = new HashMap<>();
        map.put("msg",true);
        map.put("name","张三丰");
        map.put("age",120);
        return map;
    }

}
