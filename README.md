姐妹版项目地址dubbo服务https://gitee.com/896022/shiroAuth.git

本项目采用springcloud作为微服务框架，并运用了maven的多模块结构

management-common 项目基础依赖

management-eureka-server springcloud注册服务组件

management-provider-config springcloud内部服务提供组件,持久化和业务逻辑,服务基于restful标准

management-consumer-config springcloud外部服务提供组件,依赖于内部服务提供组件,服务基于restful标准

management-zuul springcloud路由组件 对内部和外部服务提供反向代理达到集群部署分流的目的,相当于一个java版本的nginx

management-ui 基于vue的前端项目,通过调用management-consumer-config提供的外部服务接口实现整个业务功能


启动说明

1.运行需要先执行init.sql

2.启动Eureka注册服务management-eureka-server 类EurekaApplication中的main方法

3.启动内部接口服务management-provider-config 类ProviderApplication中main方法

4.启动外部接口服务management-consumer-config 类ConsumerApplication中main方法。

5.启用前端服务,需要node环境,进入management-ui目录,npm install & npm run dev 即可进行访问

5.登陆帐号admin 密码123456

6.目前zuul模块没有实际用途，供后续动静分离时使用


有使用和部署问题欢迎加群833825797讨论