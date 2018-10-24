Spring Boot 默认将 / 所有访问映射到以下目录：**

classpath:/static
classpath:/public
classpath:/resources
classpath:/META-INF/resources



Spring Boot thymeleaf 
验证码

1. 后端生成验证字符串， 放在session 里。
2. 画出来。
3. 将画出来的东西直接放到response输出流。这样的话相当于直接输出到了网页中。ajax 也就美滋滋了。

4.！！！ 前端 <img src="/我的接口">  第一次知道还能这么玩，后来想想，这个接口所链接的网页的内容只有图片内容
所以没毛病... 链接即可。 牛逼 

5. 提交的时候  ajax把文本框的内容传过去直接比较一下就行了，不过记得 后端的时候对传过来的内容要大写处理一下。

6. 没了。