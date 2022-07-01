# learn-demo
平时积累的学习项目例子和自己的一些小demo

## 模块介绍
#### 1. basic模块
基础的一些功能：
- 算法
- 设计模式
- 过滤器
- 雪花算法
- spring销毁bean
- 线程池
- trace链路
#### 2. spring-cloud-gateway-route模块
实现gateway的路由转发功能，通过nacos实现注册中心
- ##### spring-cloud-consumer模块
提供接口的服务模块
- ##### spring-cloud-provider模块
实现路由转发的服务模块
#### 3. springcloud-seate 模块
实现seate分布式事务的功能，通过order服务和product服务验证seata分布式事务。通过nacos实现注册中心以及配置列表。
- ##### seata-order模块
- ##### seata-product模块

#### 4. rpc模块
dubbo的阉割版，手写的一个rpc组件，学习netty做的相应实现，该模块中主要体现netty的使用过程。
依赖zookeeper实现注册中心。
- ##### 4.1 rpc-demo模块
rpc组件的实现类，其中包含模块有：
> common-公共模块\
>consumer-消费者实现模块\
>loadBalance-负载均衡模块\
>protocol-rpc协议模块\
>provider-提供者模块\
>registry-注册中心模块\
>remoting-远程接口模块
##### 4.2 rpc-test模块
rpc组件的example
