package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
@Tag(name = "登录管理接口", description = "登录管理相关接口")  // 描述该Controller的功能
public class LoginController {

    @GetMapping("/login")
    @Operation(summary = "用户登录", description = "用户登录成功后生成并下发JWT令牌")
    public Result login() {
        // 登陆成功生成并下发令牌,否则返回错误信息
        Map<String, Object> claims = new HashMap<>();
        claims.put("account", "admin");
        claims.put("password", "111111");
        String jwt = JwtUtils.generateJwt(claims); // 包含了当前登录的员工信息
        return Result.success(jwt);
    }
}