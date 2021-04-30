# yangyu

## 项目介绍

　　基于SpringCloud+JPA分布式敏捷开发系统架构，主要目的是能够让初级的研发人员快速的开发出复杂的业务功能，让开发者注重专注业务，其余有平台来封装技术细节，降低技术难度，从而节省人力成本，缩短项目周期，提高软件安全质量


####docker 相关
- **Nacos(2.0)** [配置相关参数](https://nacos.io/zh-cn/docs/quick-start-docker.html)
    ``` 
    docker run -p 8848:8848 -e MYSQL_SERVICE_HOST=192.168.84.128 -e MYSQL_SERVICE_PORT=3306 -e MYSQL_SERVICE_USER=root -e MYSQL_SERVICE_PASSWORD=root -e MYSQL_SERVICE_DB_NAME=nacos --name nacos -d XXX
    ```
- **Sentinel Dashboard** [下载](http://edas-public.oss-cn-hangzhou.aliyuncs.com/install_package/demo/sentinel-dashboard.jar) 
    ```
    通过运行java -jar sentinel-dashboard.jar命令来启动仪表板。 Sentinel仪表板的默认端口为8080
    ```
- **运行ElasticSearch需设置docker** 
    - 1.vi /etc/sysctl.conf
    - 2.vm.max_map_count=655360
    - 3.sysctl -p
- **elasticsearch(5.4.0)** 
    ``` 
    docker run --name=elasticsearch -p 9200:9200 -p 9300:9300 -v /usr/elk-config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml -v /usr/elk-config/jvm.options:/etc/elasticsearch/jvm.options -d XXX
    ```
- **kibana(5.4.0)** 
    ```
    docker run --name kibana -e ELASTICSEARCH_URL=http://192.168.99.100:9200 -p 5601:5601 -d XXX
    ```
- **logstash(需要含有mysql-connector-java)** 
    ```
    docker run -it --rm XXX -e 'input {
       jdbc {
         jdbc_driver_library => "/usr/download/mysql-connector-java-5.1.21.jar"
         jdbc_driver_class => "com.mysql.jdbc.Driver"
         jdbc_connection_string => "jdbc:mysql://192.168.99.100:3306/yangyu?characterEncoding=UTF-8&useSSL=false"
         jdbc_user => "root"
         jdbc_password => "root"
         statement => "SELECT n.id,n.author,n.content_part,n.href,n.publish_date,n.title,n.avatar FROM yangyu_news n where n.publish_date > :sql_last_value"    //sql_last_value为上一次更新的最后时刻值
         jdbc_paging_enabled => "true"
         jdbc_page_size => "50000"
         schedule => "* * 1/1 * *"  //分别代表分、时、天、月、年
       }
     }
 
     filter {
        json {
             source => "message"
             remove_field => ["message"]
         }
     }
 
     output {
       stdout {
         codec => rubydebug
       }
       elasticsearch {
         hosts => "192.168.99.100:9200"
         index => "yangyu-news-%{+YYYY.MM.dd}"
       }        
     }
- **zookeeper(3.4.9)**
    ```
    docker run -d --name zookeeper -p 2181:2181 XXX
    ```
- **kafka(0.9.0.1)**
    ```
    //不添加这个会连接不到kafka导致[passed since batch creation plus linger time]错误(KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.99.100:9092)
    docker run --name kafka -d -e HOST_IP=localhost -e KAFKA_ADVERTISED_PORT=9092 -e KAFKA_BROKER_ID=1 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.99.100:9092 -e ZK=zk -p 9092:9092 --link zookeeper:zk -t bb084b80bef3
    docker run -d --name kafka -p 9092:9092 --link zookeeper -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_HOST_NAME=localhost -e KAFKA_ADVERTISED_PORT=9092 XXX
    1.创建一个 topic 名称为 test
        bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic test
    2.查看当前的 topic 列表
        bin/kafka-topics.sh --list --zookeeper zookeeper:2181
    3.运行一个消息生产者，指定 topic 为刚刚创建的 test 
        bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
    4.运行一个消息消费者，同样指定 topic 为 test
        bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --zookeeper:2181 --topic test --from-beginning

    ```
