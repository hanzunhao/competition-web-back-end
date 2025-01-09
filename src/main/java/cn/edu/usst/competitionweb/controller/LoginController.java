package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/login")
@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @PutMapping
    public Result login() {
        log.info("用户登录");
        //登陆成功生成并下发令牌,否则返回错误信息//否则返回错误信息
        if (true) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", 1);
            claims.put("username", "a");
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        } else {
            return Result.error("用户名或密码错误！");
        }
    }
}
