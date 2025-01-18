package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.pojo.User;
import cn.edu.usst.competitionweb.service.UserService;
import cn.edu.usst.competitionweb.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/login")
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result login(@RequestBody User user) {
        log.info("用户登录:{}", user);
        User u = userService.login(user);

        //登陆成功生成并下发令牌,否则返回错误信息
        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("account", u.getAccount());
            claims.put("password", u.getPassword());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        } else {
            return Result.error("用户名或密码错误！");
        }
    }
}
