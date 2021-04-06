# KLE	

Elasticsearch + Logstash + Kibana 线上日志系统

# 环境依赖

* Docker
* Docler-compose

```bash
# 创建elasticsearch数据文件目录
mkdir /mydata/elasticsearch/data

# 赋予相应权限
sudo chmod 777 /mydata/elasticsearch/data

# 创建logstash数据文件目录
mkdir /mydata/logstash
```

在 `/mydata/logstash` 目录下创建 `logstash-springboot.conf` 

```nginx
input {
  tcp {
    mode => "server"
    host => "0.0.0.0"
    port => 4560
    codec => json_lines
  }
}
output {
  elasticsearch {
    hosts => "es:9200"
    index => "springboot-logstash-%{+YYYY.MM.dd}"
  }
}
```

# 部署

```sh
# 克隆项目
git clone https://github.com/TouwaErioer/shuttle-cloud.git

# 因为项目涉及到文件的读写，要开放相应的权限
sudo chmod 777 shuttle-cloud

# 切换到项目
cd shuttle-cloud/KLE

# 在后台启动
sudo docker-compose up -d

# 停止并删除容器
sudo docker-compose down

# 停止
sudo docker-compose stop
```
