

1.其实和HunnuApplication （启动类） 在同一个包不会被自动扫描到 应该配置componentscan扫描本包！

2. 配置拦截器

 2.1 自定义一个拦截器 继承HandlerInterceptorAdapter 然后实现其中的方法即可

 2.2 给自定义的拦截器进行注册
     1.创建一个类 完成WebMvcConfigurer 接口（SpringBoot 2.x 使用）
     2.实现里面的 addInterceptors 方法
      @Override
         public void addInterceptors(InterceptorRegistry registry) {
             //注册一个自定义的拦截器实例 并且配置好其拦截的对象url patten
             registry.addInterceptor(new TestInterceptor()).addPathPatterns("/Interceptor1/**");

         }

      new TestInterceptor() 是自定义的那个拦截器的一个实例
      addPathPatterns("") 是指拦截的 urlpattern

      /*代表当前目录
      /**代表当前所有目录，包括子目录


 3. thymeleaf 默认的静态资源路径是 src/main/resources/下的 static
    配置了拦截器的时候要注意多加一个命名空间以区别静态资源和拦截的资源
    然后注意静态资源的加载路径，是在当前网页的路径的基础上去进行静态资源的加载
    如
     @GetMapping("/Interceptor1/index")
        public String index2(){
            System.out.println("/Interceptor1/index");
            return "index2";
        }

      index2.html 的当前路径应该为 http://localhost:8088/Interceptor1/index
      而静态资源jquery的路径为 http://localhost:8088/jquery-1.9.1.js
      此时想要在 index2.html中加载jquery
      需要填写的路径为
      <script type="text/javascript" src="../jquery-1.9.1.js"></script>