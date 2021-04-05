# 项目介绍

**shuttle-cloud** 是项目 [shuttle](https://github.com/TouwaErioer/shuttle) 基于 **Spring Cloud** 的分布式实现，采用了 **Spring Cloud Eureka**、**Spring Cloud Config**、**Spring Boot Admin**、**Spring Cloud Gateway**、**Spring Cloud OpenFeign**、**Docker**等核心技术，同时提供了基于Vue的前端项目 [shuttle-web](https://github.com/TouwaErioer/shuttle-web) 和后台管理系统 [shuttle-admin](https://github.com/TouwaErioer/shuttle-admin)

# 系统架构图

![shuttle-cloud](https://ae01.alicdn.com/kf/Uc6645839751d4f098b00ce0e75c1083fg.jpg)

# 项目结构

```
shuttle-cloud
├── admin -- 微服务监控中心
├── config -- 全局配置中心
├── eureka -- 微服务注册中心
├── gateway -- 项目服务网关
├── major -- 服务、类别、商店、产品、评论、广告相关模块
├── orders -- 订单相关模块
└── user -- 用户相关模块
```

# 效果

# 部署顺序

> 请阅读相关项目下的 README.md

1. [eureka](https://github.com/TouwaErioer/shuttle-cloud/tree/master/eureka)
2. [config](https://github.com/TouwaErioer/shuttle-cloud/tree/master/config)
3. [admin](https://github.com/TouwaErioer/shuttle-cloud/tree/master/admin)
4. [gateway](https://github.com/TouwaErioer/shuttle-cloud/tree/master/gateway)
5. [user](https://github.com/TouwaErioer/shuttle-cloud/tree/master/user)
6. [major](https://github.com/TouwaErioer/shuttle-cloud/tree/master/major)
7. [orders](https://github.com/TouwaErioer/shuttle-cloud/tree/master/orders)

