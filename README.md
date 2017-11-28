# yangyu


####docker ELK启动

- 运行ElasticSearch需设置docker 
    - 1.vi /etc/sysctl.conf
    - 2.vm.max_map_count=655360
    - 3.sysctl -p
- docker容器中安装vi命令
    - apt-get update
    - apt-get install vim
- elasticsearch(5.4.0): 
    ``` 
    docker run --name=elasticsearch -p 9200:9200 -p 9300:9300 -v /usr/elk-config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml -v /usr/elk-config/jvm.options:/etc/elasticsearch/jvm.options -d XXX
    ```
- kibana(5.4.0) 
    ```
    docker run --name kibana -e ELASTICSEARCH_URL=http://192.168.99.100:9200 -p 5601:5601 -d XXX
    ```
- logstash(需要含有mysql-connector-java) 
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
- zookeeper(3.4.9)
    ```
    docker run -d --name zookeeper -p 2181:2181 XXX
    ```
- kafka(0.9.0.1)
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
