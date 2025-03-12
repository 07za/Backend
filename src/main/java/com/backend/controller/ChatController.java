package com.backend.controller;

import com.backend.pojo.Result;
import com.backend.pojo.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ChatController {

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user, HttpSession session){
        // 数据库验证 TODO()
        if ((user.getUsername().equals("qy01") && user.getPassword().equals("123456")) ||
                (user.getUsername().equals("kf01") && user.getPassword().equals("123456"))
        ){
            // 存储用户名，让后续使用
            session.setAttribute("user",user.getUsername());
            return Result.success();
        }else {
            return Result.error("？？？你加油");
        }


    }
}
