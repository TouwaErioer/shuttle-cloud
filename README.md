# 项目介绍

**shuttle-cloud** 是项目 [shuttle](https://github.com/TouwaErioer/shuttle) 基于 **Spring Cloud** 的分布式实现

基于Vue的前端项目 [shuttle-web](https://github.com/TouwaErioer/shuttle-web) 和后台管理系统 [shuttle-admin](https://github.com/TouwaErioer/shuttle-admin)

# 技术选型

服务发现中心：**Spring Cloud Eureka**

全局配置中心：**Spring Cloud Config**

服务监控中心：**Spring Boot Admin**

服务网关中心：**Spring Cloud Gateway**

服务调用：**Spring Cloud OpenFeign**

部署工具：**Docker-Compose**

# 在线预览

> 测试账号：用户 `geust` 密码 `geust`

[shuttle-web](https://shuttle-web.vercel.app/) 

[shuttle-admin](https://shuttle-admin.vercel.app)

# 系统架构图

![shuttle-cloud](https://ae01.alicdn.com/kf/Uc6645839751d4f098b00ce0e75c1083fg.jpg)

# 项目结构

```
shuttle-cloud
├── admin -- 微服务监控中心
├── config -- 全局配置中心
├── eureka -- 微服务注册中心
├── gateway -- 项目服务网关
├── KLE -- 线上日志系统
├── major -- 服务、类别、商店、产品、评论、广告相关模块
├── orders -- 订单相关模块
└── user -- 用户相关模块
```

# 效果

Spring Boot Admin

![Spring-Boot-Admin](https://ae01.alicdn.com/kf/U664254423e20400bb231c0267ab72a26S.jpg)

![Detail](https://ae01.alicdn.com/kf/Uc8b8d3ec54b94d468977377d6997acc1h.jpg)

KLE

![kLE](https://ae01.alicdn.com/kf/Ucc0eb37f724c4909b87d0568530401e7F.jpg)

# 部署顺序

> 请阅读相关项目下的 README.md
1. [KLE](https://github.com/TouwaErioer/shuttle-cloud/tree/master/KLE)
2. [eureka](https://github.com/TouwaErioer/shuttle-cloud/tree/master/eureka)
3. [config](https://github.com/TouwaErioer/shuttle-cloud/tree/master/config)
4. [admin](https://github.com/TouwaErioer/shuttle-cloud/tree/master/admin)
5. [gateway](https://github.com/TouwaErioer/shuttle-cloud/tree/master/gateway)
6. [user](https://github.com/TouwaErioer/shuttle-cloud/tree/master/user)
7. [major](https://github.com/TouwaErioer/shuttle-cloud/tree/master/major)
8. [orders](https://github.com/TouwaErioer/shuttle-cloud/tree/master/orders)

