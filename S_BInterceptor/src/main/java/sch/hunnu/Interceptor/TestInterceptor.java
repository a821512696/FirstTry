package sch.hunnu.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *  自定义的拦截器 用来显示时间 稍后在 WebMvcConfigurer 里配置一下即可
 *  拦截器用来做 登陆验证 安全验证 这些 确实很棒~
 */
public class TestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("现在的时间是：\n"+new Date().toLocaleString());
    //    response.sendRedirect("/Hi2");  //完美重定向
    //    return false;           //return false; 如果只有一个拦截器那么 会使得请求从此刻开始就结束了。不会进入controller了~
        return true;                //return true;请求会继续进行
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("结束了！");
    }

}
