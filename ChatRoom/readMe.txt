并不是一打开浏览器就会有一个session.
得要从HttpServletRequest 里获取才会创建session.
并不是一关闭浏览器就会让session失效。得调用invalid（）方法，或者等session到失效时间，或者关闭服务器。


spring boot 设置 servlet  的 session失效时间 （默认是60秒）
server:
  servlet:
    session:
      timeout: 3600   #servlet session 的会话超时 3600s   


sql 
union和union all的区别是,union会自动压缩多个结果集合中的重复结果,而union all则将所有的结果全部显示出来,不管是不是重复。 


js

js获取时间戳 毫秒数
 var timestamp2 =(new Date()).valueOf();
 
jquery 使用周期调用函数
setInterval(liveOfSession,3000);
		第一个参数直接写方法名
		
 //在原有窗口打开
    window.location.href = "http://www.baidu.com";
    //打开新的窗口
    window.open("http://www.baidu.com");		
		
1.当进入聊天页面时（用户登录成功时）,开启一个session专门给这个用户来用。
（用request.getSession(true);）当没有session时创建一个新的session有的话就获取这个session.
2.监听类监听session的产生，并且将sessionID放入一个bean(List<String>)中
再 开启一个后台进程 一直进行时间检查。当用户的聊天页面关闭超过2分钟后则进行session的注销。
这个时候就会被监听类监听到session的消亡。这个时候将将sessionID移出bean(List<String>);

想知道人数，则获取bean(List<String>)的size就行了。

等下用map试试。

1.前端 ajax 更新当前时间。 