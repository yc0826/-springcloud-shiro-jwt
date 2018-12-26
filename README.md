姐妹版项目地址 dubbo 服务https://gitee.com/896022/shiroAuth.git

本项目采用 springcloud 作为微服务框架，并运用了 maven 的多模块结构

management-common 项目基础依赖

management-eureka-server springcloud 注册服务组件

management-provider-config springcloud 内部服务提供组件,持久化和业务逻辑,服务基于 restful 标准

management-consumer-config springcloud 外部服务提供组件,依赖于内部服务提供组件,服务基于 restful 标准

management-zuul springcloud 路由组件 对内部和外部服务提供反向代理达到集群部署分流的目的,相当于一个 java 版本的 nginx

management-ui 基于 vue 的前端项目,通过调用 management-consumer-config 提供的外部服务接口实现整个业务功能

启动说明

1.运行需要先执行 init.sql，修改 management-provider-config 模块中 application.yml 的 jdbc 连接

2.启动 Eureka 注册服务 management-eureka-server 类 EurekaApplication 中的 main 方法

3.启动内部接口服务 management-provider-config 类 ProviderApplication 中 main 方法

4.启动外部接口服务 management-consumer-config 类 ConsumerApplication 中 main 方法。

5.启用前端服务,需要 node 环境,进入 management-ui 目录,npm install & npm run dev 即可进行访问

5.登陆帐号 admin 密码 123456

6.目前 zuul 模块没有实际用途，供后续动静分离时使用

有使用和部署问题欢迎加群 833825797 讨论
