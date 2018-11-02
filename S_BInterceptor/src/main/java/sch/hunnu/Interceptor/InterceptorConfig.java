package sch.hunnu.Interceptor;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import sch.hunnu.Interceptor.TestInterceptor;

@Configuration                              //配置一个拦截器 需要在WebMvcConfigurer 里进行注册
public class InterceptorConfig implements WebMvcConfigurer {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册一个自定义的拦截器实例 并且配置好其拦截的对象url patten
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/Interceptor1/**");
        //当然就可以依葫芦画瓢 多注入几个拦截器~
    }
}
