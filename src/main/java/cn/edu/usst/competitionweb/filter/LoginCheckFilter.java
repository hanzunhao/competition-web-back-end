package cn.edu.usst.competitionweb.filter;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.utils.JwtUtils;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 检查是否是 WebSocket 握手请求
        if ("Upgrade".equalsIgnoreCase(req.getHeader("Connection")) && "websocket".equalsIgnoreCase(req.getHeader("Upgrade"))) {
            // WebSocket 握手请求，直接放行
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 其他 HTTP 请求的逻辑
        String url = req.getRequestURL().toString();
        log.info("请求的url：{}", url);
        if (url.contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String jwt = req.getHeader("token");
        log.info(jwt);
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空，返回未登陆的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败返回未登录的错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        log.info("令牌合法，直接放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
