# yangyu


####docker ELK启动

- 设置docker 
    - 1.vi /etc/sysctl.conf
    - 2.vm.max_map_count=655360
    - 3.sysctl -p

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
- docker容器中安装vi命令
    - apt-get update
    - apt-get install vim
