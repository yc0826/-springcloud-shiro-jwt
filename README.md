本项目采用springcloud作为微服务框架，并运用了maven的多模块结构

姐妹版项目地址dubbo服务https://gitee.com/896022/shiroAuth.git

启动说明

1.运行需要先执行init.sql

2.启动Eureka注册服务management-register-server main方法

3.启动内部接口服务management-rpc-service main方法

4.启动web服务management-web-server main方法。

5.启用前端服务,需要node环境,进入management-ui目录,npm install & npm run dev 即可进行访问

5.登陆帐号admin 密码123456

6.目前zuul模块没有实际用途，供后续动静分离时使用


有使用和部署问题加群833825797讨论

