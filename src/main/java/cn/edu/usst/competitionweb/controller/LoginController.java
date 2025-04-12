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
@Tag(name = "认证接口",description = "系统登录及令牌管理")
public class LoginController {

    @GetMapping("/login")
    @Operation(summary = "管理员登录",description = "使用预设凭证获取JWT令牌（当前时间16:54检测到高频访问）")
    public Result login() {
        // 登陆成功生成并下发令牌,否则返回错误信息
        Map<String, Object> claims = new HashMap<>();
        claims.put("account", "admin");
        claims.put("password", "111111");
        String jwt = JwtUtils.generateJwt(claims); // 包含了当前登录的员工信息
        return Result.success(jwt);
    }
}