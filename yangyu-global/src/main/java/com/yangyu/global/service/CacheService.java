package com.yangyu.global.service;

import com.yangyu.common.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.query.SortQueryBuilder;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.Jedis;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import org.springframework.dao.DataAccessException;

@Configuration
@ConditionalOnClass({ Jedis.class, StringRedisTemplate.class })
public class CacheService {

    /** @see org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration.RedisConfiguration */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /** 往 redis 中放值: set key value */
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }
    /** 往 redis 放值, 并设定超时时间: setex key seconds value */
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }
    /** 往 redis 放值, 调用成功者返回 true. 此方法如果被多线程调用, 只有一个会返回 true, 其他会返回 false: setnx key 1 */
    public boolean setIfAbsent(String key) {
        return stringRedisTemplate.opsForValue().setIfAbsent(key, "1");
    }
    /** 往 redis 放值并设置过期时间, 调用成功者返回 true. 此方法如果被多线程调用, 只有一个会返回 true, 其他会返回 false: setnx key 1 */
    public boolean setIfAbsent(String key, long timeout, TimeUnit timeUnit) {
        // redisTemplate 不支持 set key value EX timeout NX 这种命令
        boolean flag = setIfAbsent(key);
        boolean expireFlag = stringRedisTemplate.expire(key, timeout, timeUnit);
        return flag && expireFlag;
    }
    /** 从 redis 中取字符: get key */
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    /** 从 redis 中删值: del key */
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }
    /** 向队列(先进先出)写值(从左边压栈): lpush key */
    public void listPush(String key, String value) {
        stringRedisTemplate.opsForList().leftPush(key, value);
    }
    /** 向队列(先进先出)读值(从右边出栈): rpop key */
    public Object listPop(String key) {
        return stringRedisTemplate.opsForList().rightPop(key);
    }


    /** 获取指定 set 的长度: scard key */
    public long setSize(String key) {
        return stringRedisTemplate.opsForSet().size(key);
    }
    /** 将指定的 set 存进 redis 的 set 并返回成功条数: sadd key v1 v2 v3 ... */
    public long setAdd(String key, String[] set) {
        return stringRedisTemplate.opsForSet().add(key, set);
    }
    /** 从指定的 set 中随机取一个值: spop key */
    public Object setPop(String key) {
        return stringRedisTemplate.opsForSet().pop(key);
    }


    /**
     * 批量查询
     *
     * @param list
     * @return
     */
    public Map<String,String> executePipelinedQuery(List<String> list){
       // RedisConnectionFactory factory = stringRedisTemplate.getConnectionFactory();
        //RedisConnection redisConnection = factory.getConnection();
        //redisConnection.openPipeline();
        //redisConnection.set(xxxx);
        //redisConnection.closePipeline();
        Map<String,String> map = new HashMap<>();
        RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
        RedisCallback<String> pipelineCallback = (connection) -> {
            connection.openPipeline();
            list.forEach(m -> connection.get(serializer.serialize(m))); //m.getBytes(Charset.forName("utf-8"))
            connection.closePipeline();
            return null;
        };
        List<Object> results = stringRedisTemplate.executePipelined(pipelineCallback);
        int i=0;
        for (Object o : results) {
            if(o!=null) {
                map.put( list.get(i).toString(),String.valueOf(o));
                i++; //不知道位置对不对，可能获取的返回值跟key不对应，如果不对的话，只能使用单个操作，或者是原生的jedis 的 Response
            }
        }
        return null;
    }
    /**
     * 批量插入，不需要返回值
     *
     */
    public Boolean executePipelinedInsert(Map<String,String> map){
        RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
        RedisCallback<Boolean> pipelineCallback = (connection)-> {
            connection.openPipeline();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                byte[] key  = serializer.serialize(entry.getKey());
                byte[] name = serializer.serialize(entry.getValue());
                connection.set(key,name);
            }
            connection.closePipeline();
            return true;
        };
        Boolean results = stringRedisTemplate.execute(pipelineCallback);
        return results;
    }

    /** 批量从 redis 中删值: del key */
    public void delete(List<String> keys) {
        stringRedisTemplate.delete(keys);
    }
    /*** 设置某个KEY的过期时间,以秒为单位*/
    public void expire(String key,long timeout) {
        setIfAbsent(key,timeout,TimeUnit.SECONDS);
    }
    public long zCard(String key) {
        return stringRedisTemplate.opsForZSet().zCard(key);
    }

    /***按照sorce倒序***/
    public Set<String> zrevrange(String key,long start,long end) {
        return stringRedisTemplate.opsForZSet().reverseRange(key,start,end);
    }
    /***获取zset的元素总数***/
    public Long zlength(String key) {
        return stringRedisTemplate.opsForZSet().size(key);
    }

    /**
     * 按照自己本身（默认)排序
     *对List,Set,SortSet进行排序或limit
     * @param key
     * @param start
     * @param sortType asc desc
     * @return
     */
    public List<String> sort(String key,long start,long count,String sortType) {
        SortQueryBuilder<String> builder = SortQueryBuilder.sort(key);
        if( "asc".equals(sortType.toLowerCase()))
            builder.order(SortParameters.Order.ASC);
        else if ( "desc".equals(sortType.toLowerCase()))
            builder.order(SortParameters.Order.DESC);
        else
            builder.order(SortParameters.Order.DESC);
        builder.limit(start, count);
        return stringRedisTemplate.sort(builder.build());
    }

    /**
     *
     * @param key
     * @param map value,score
     * @return
     */
    public Long zAdd(String key,Map<String,Double> map){
        Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<String>>set = new HashSet<>();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            org.springframework.data.redis.core.ZSetOperations.TypedTuple<String> tuple =
                    new org.springframework.data.redis.core.DefaultTypedTuple<>(entry.getKey(),entry.getValue());
            set.add(tuple);
        }
        return stringRedisTemplate.opsForZSet().add(key,set);
    }

    public void setAdd(String key,String value){
        stringRedisTemplate.opsForSet().add(key,value);
    }

    public boolean setIsMember(String key, String value){
        return stringRedisTemplate.opsForSet().isMember(key,value);
    }

}
