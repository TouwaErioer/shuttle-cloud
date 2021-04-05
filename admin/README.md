# admin

服务监控中心

# 依赖

| Description | Version|
|  :----: | :----: |
| spring-boot-starter-parent | 2.1.7.RELEASE |
| spring-cloud | Greenwich.SR2 |
| spring-boot-starter-web | latest |
| spring-cloud-starter-config | latest |
| spring-boot-starter-security | latest |
| spring-cloud-starter-netflix-eureka-client | latest |
| spring-boot-admin-starter-server | 2.1.5 |
| spring-boot-starter-actuator | latest |
| spring-boot-starter-jetty | latest |

# 必要参数

请在项目根目录 `.env` 文件里完成参数填写

```sh
port= # http端口
configLabel= # 配置分支
configUrl= # 配置地址
configName= # 配置名称
configSecurityName= # 配置账户
configSecurityPassword= # 配置密码
```

# 环境依赖

* Docker
* Docler-compose

# 部署

```sh
# 克隆项目
git clone https://github.com/TouwaErioer/shuttle-cloud.git

# 因为项目涉及到文件的读写，要开放相应的权限
sudo chmod 777 shuttle-cloud

# 切换到项目
cd shuttle-cloud/admin

# 请完成.env文件参数填写

# 在后台启动
sudo docker-compose up -d

# 停止并删除容器
sudo docker-compose down

# 停止
sudo docker-compose stop
```
