package cn.edu.usst.competitionweb.filter;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.utils.JwtUtils;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(LoginCheckFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //1.获取请求url
        String url = req.getRequestURL().toString();
        log.info("请求的url：{}", url);
        //2.判断url中是否含有login，如果包含，放行
        if (url.contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //3.获取请求头中的令牌token
        String jwt = req.getHeader("token");
        //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空，返回未登陆的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);//由于并不在controller层，需要手动将Result转为json（阿里巴巴fastJSON工具包）
            resp.getWriter().write(notLogin);//通过流直接返回给浏览器
            return;
        }
        //5.解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败返回未登录的错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);//由于并不在controller层，需要手动将Result转为json（阿里巴巴fastJSON工具包）
            resp.getWriter().write(notLogin);//通过流直接返回给浏览器
            return;
        }
        //6.放行
        log.info("令牌合法，直接放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
