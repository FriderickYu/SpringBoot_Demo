package org.ytq.Interceptor;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.ytq.utils.JwtUtil;
import org.ytq.vo.Encapulation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class JwtValidateInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("X-Token");
        log.debug(request.getRequestURI() + "需要验证: " + token);
        if(token != null){
            try {
                jwtUtil.parseToken(token);
                log.debug(request.getRequestURI() + "验证通过: " + token);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        log.debug(request.getRequestURI() + "验证失败，禁止访问: " + token);
        response.setContentType("application/json;charset=utf-8");
        Encapulation<Object> fail = Encapulation.fail(20003, "jwt无效，请重新登录");
        response.getWriter().write(JSON.toJSONString(fail));
        return false; //禁止通行
    }
}
