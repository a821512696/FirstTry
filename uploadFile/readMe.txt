1.表单提交 上传单个文件
2.表单提交 上传多个文件

在类中取得路径： 
得到工程的路径：System.getProperty("user.dir") 


因为想用的是一般的方法，即在SpringBoot和SSM中均可使用 故而需要关闭SpringBoot自带的上传组件
spring:
  servlet:
    multipart:
      enabled: false

 