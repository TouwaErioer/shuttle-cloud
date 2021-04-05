# gateway

网关服务中心

## 依赖

| Description | Version|
|  :----: | :----: |
| spring-boot-starter-parent | 2.0.6.RELEASE |
| spring-cloud | Finchley.SR2 |
| spring-boot-starter-security | latest |
| spring-cloud-starter-netflix-eureka-client | latest |
| spring-cloud-starter-netflix-hystrix | latest |
| spring-boot-starter-actuator | latest |
| spring-boot-starter-data-redis-reactive | latest |

## 必要参数

请在项目根目录 `.env` 文件里完成参数填写

```sh
port= # http端口
eurekaUser= # eureka用户
eurekaPassword= # eureka密码
eurekaUrl= # eureka地址
eurekaPort= # eureka端口
host= # 部署服务器公网ip
redisPassword= # redis密码
```

## 环境依赖

* Docker
* Docler-compose

## 部署

```sh
# 克隆项目
git clone https://github.com/TouwaErioer/shuttle-cloud.git

# 因为项目涉及到文件的读写，要开放相应的权限
sudo chmod 777 shuttle-cloud

# 切换到项目
cd shuttle-cloud/gateway

# 请完成.env文件参数填写

# 在后台启动
sudo docker-compose up -d

# 停止并删除容器
sudo docker-compose down

# 停止
sudo docker-compose stop
```
