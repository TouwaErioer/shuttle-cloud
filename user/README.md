# user

用户相关服务

## 依赖

| Description | Version|
|  :----: | :----: |
| Spring Boot | 2.4.4 |
| Redis | 4.0.9 |
| Mysql | 5.5 |
| Druid | 1.1.10 |
| MyBatis | 2.1.0 |
| log4j2 | 2.13.2 |
| RabbitMQ | latest |
| JWT | 3.4.0 |
| PageHelper | 1.2.5 |

## 必要参数

请在项目根目录 `.env` 文件里完成参数填写

```sh
port= # http端口
dbPassword= # 数据库密码
host= # 部署服务器公网ip
redisPassword= # redis密码
configLabel= # 配置分支
configUrl= # 配置地址
configName= # 配置名称
configSecurityName= # 配置账户
configSecurityPassword= # 配置密码
```

## 环境依赖

* Docker
* Docler-compose

## 必要文件

请在根目录添加如下文件

```
# 支付宝沙盒私钥
private.txt

# 支付宝沙盒公钥
public.txt
```

## 部署

```sh
# 克隆项目
git clone https://github.com/TouwaErioer/shuttle-cloud.git

# 因为项目涉及到文件的读写，要开放相应的权限
sudo chmod 777 shuttle-cloud

# 切换到项目
cd shuttle-cloud/user

# 请完成.env文件参数填写

# 在后台启动
sudo docker-compose up -d

# 停止并删除容器
sudo docker-compose down

# 停止
sudo docker-compose stop
```
