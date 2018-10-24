D:\RabbitMQ\rabbitmq_server-3.7.8
！！！！
1.真的坑，默认路径C:\Program Files\Rabbit MQServer里有2个空格。
而安装路径是不能有空格的
所以我放到了D盘下

！！！！
1. 卸载后 重启 然后删掉C:\Users\Hi\AppData\Roaming\RabbitMQ\里的所有东西 ！！！ 当然要先装Erlang   然后再安装！

2. 其实验证成不成功就看 C:\Users\Hi\AppData\Roaming\RabbitMQ\db\rabbit@Hi-mnesia 这个目录下有没有文件了。 没有的话 那就只能是重装了。

启动web服务  
1. 管理员权限启动cmd 进入安装的 sbin目录下  然后输入命令
rabbitmq-plugins.bat enable rabbitmq_management

2. 如果你发现没有RabbitMQ 服务！！！
管理员权限启动cmd  进入安装目录的sbin目录下 输入命令进行服务的安装
rabbitmq-service.bat install

然后就可以打开 http://localhost:15762/
开始快乐了！！


