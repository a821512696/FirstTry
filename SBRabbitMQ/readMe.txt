
1.安装Erlang 安装最新的版本吧 装好后记得配置系统环境和jdk类似
cmd 输入erl 查看当前版本就可以知道有没有成功了
2.安装RabbitMQ 如果Erlang版本低了会有提示的
安装有几个坑！
1.安装目录不能有空格的，而它默认的目录有2个空格！！2个啊！！！贼恐怖
有空格会导致很多问题 比如 无法访问你的本机结点啊
详细看readME2.txt


SpringBoot开始整合rabitmq

1.导包见pom.xml

2. 写一个配置类吧，我这里写到工具类里去了。sch.hunnu.Utils.rabbitMQUtil.java
注入各种Bean 主要是3类 队列、exchange和binding.
主要是体验了一下3种Exchange的使用
Exchange的routeKey 其实就是 .with("xxx")  with里面的东西了。
然后客户端会要用一个自己提供的routeKey来进行和 Exchange 自己routeKey进行匹配。
姑且叫 Exchange的routeKey  key1
client的routeKey key2

direct : key2 与key1完全相同

fanout : key2随意指定,反正是广播方式，与FanExchange绑定的queue都会收到信息的。

topic  ：key2 与key1 进行匹配。按照匹配结果进行分派信息。
			.用来分割单词
			#代表着0个或者多个
			*代表一个
过程基本就是：生成queue、exchange
然后生成binding(需要传入queue和exchange)



3.写sender 详情见sch.hunnu.service.helloQueueSend.java
 AmqpTemplate 这个类SpringBoot已经整合好了，直接用就行了，特别方便。注意一下它的API;
 其实也可以都用一个方法 rabbit.convertAndSend(exchange, routingKey, message);
 当然也可以用rabbit.convertAndSend(routingKey, message);这意味着使用默认的Exchange 以direct的方式进行路由分配

4.写receiver 详情见sch.hunnu.service.helloQueueReceiver.java
在方法上加上@RabbitListener(queues="xxx")可以指定这个方法监听的队列是谁。很方便...
connection、 channal这些细节都不用写了，当然我现在也没去了解细节。
只是想着熟悉一下RabbitMQ

5.然后就是各种测试了。我用web controller的方式做的。 

细节一般都写在注释里了。
不过我都不愿意再看了。

