# config

服务配置中心

# 依赖

| Description | Version|
|  :----: | :----: |
| spring-boot-starter-parent | 2.1.7.RELEASE |
| spring-cloud | Greenwich.SR2 |
| spring-boot-starter-web | latest |
| spring-cloud-config-server | latest |
| spring-boot-starter-security | latest |
| spring-cloud-starter-netflix-eureka-client | latest |
| spring-cloud-starter-bus-amqp | latest |
| spring-boot-starter-actuator | latest |

# 创建Github私有配置仓库

创建 `admin.properties`

```sh
port= # http端口
eurekaUser= # eureka用户
eurekaPassword= # eureka密码
eurekaUrl= # eureka地址
eurekaPort= # eureka端口
adminUser= # 访问用户
adminPassword= # 访问密码
```

创建 `user.properties`

```sh
key= # jwt密钥
appId= # 支付宝沙盒应用id
gateway= # 支付宝沙盒网关
redirectUrl= # 支付宝沙盒重定向地址
elasticsearchUrl= # elasticsearch地址
eurekaUser= # eureka用户
eurekaPassword= # eureka密码
eurekaUrl= # eureka地址
eurekaPort= # eureka端口
druidUser=shuttle # druid用户
druidPasswd=shuttle # druid密码
mqHost= # rabbitmq地址
```

创建 `major.properties`

```sh
key= # jwt密钥
eurekaUser= # eureka用户
eurekaPassword= # eureka密码
eurekaUrl= # eureka地址
eurekaPort= # eureka端口
druidUser=shuttle # druid用户
druidPasswd=shuttle # druid密码
elasticsearchUrl= # elasticsearch地址
```

创建 `order.properties`

```sh
key= # jwt密钥
eurekaUser= # eureka用户
eurekaPassword= # eureka密码
eurekaUrl= # eureka地址
eurekaPort= # eureka端口
druidUser=shuttle # druid用户
druidPasswd=shuttle # druid密码
```

## 必要参数

请在项目根目录 `.env` 文件里完成参数填写

```sh
port= # http端口
gitUri= # github地址
gitUserName= # github账户
gitPassword= # github密码
securityName= # 访问用户
securityPassword= # 访问密码
eurekaUser= # eureka用户
eurekaPassword= # eurek密码
eurekaUrl= # eurek地址
eurekaPort= # eurek端口
rabbitUser= # rabitmq用户
rabbitPassword= # rabitmq密码
host= # 部署服务器公网ip
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
cd shuttle-cloud/config

# 请完成.env文件参数填写

# 在后台启动
sudo docker-compose up -d

# 停止并删除容器
sudo docker-compose down

# 停止
sudo docker-compose stop
```
