# SpringMvcStudy

learning Spring Mvc

# 1.spring-mvc-mqtt

mqtt 的测试服务器地址为： 192.168.191.32:1883

## 服务端（生产者）

spring-mvc-mqtt-server

spring-mqtt.xml文件中配置服务器地址，账号，密码。

注意jetty启动的端口不能与客户端冲突。

发消息接口

- POST
- http://localhost:8080/mqtt/send

```
{
	"message":"hello, 你好"
}
```



## 客户端（消费者）

spring-mvc-mqtt-client

spring-mqtt.xml文件中配置服务器地址，账号，密码。

注意jetty启动的端口不能与服务端冲突。

客户端控制台输出日志：

```
hello, 你好！
```



