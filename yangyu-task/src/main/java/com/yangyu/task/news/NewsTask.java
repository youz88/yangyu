package com.yangyu.task.news;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.yangyu.api.NewsApi;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.global.service.CacheService;
import com.yangyu.news.api.dto.NewsSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/**
 * Created by youz on 2017/11/9.
 */
@Component
public class NewsTask{

    private static Integer MAX_EXPECTEDINSERTIONS = 100000000;

    private static BloomFilter hrefFileter = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8),MAX_EXPECTEDINSERTIONS);

    @Value("${yangyu.news.fileName}")
    private String fileName;

    @Autowired
    private NewsApi newsApi;

    @Autowired
    private CacheService cacheService;

    @Scheduled(cron = "0/30 * * * * ?")
//    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void catchNews(){
        List<NewsSaveDto> list = readData();
        newsApi.save(list);
    }

    public List<NewsSaveDto> readData(){
        StringBuffer buffer = new StringBuffer("[");
        String filePath = NewsTask.class.getResource("/").getPath().substring(1)+fileName;
        String[] arg = new String[]{"python",filePath,"1"};
        BufferedReader br = null;
        InputStream is = null;
        try {
            is = Runtime.getRuntime().exec(arg).getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while((line=br.readLine())!=null){
                buffer.append(line).append(",");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<NewsSaveDto> list = JsonUtil.toList(buffer.substring(0, buffer.length() - 1) + "]", NewsSaveDto.class);
        buffer = null;
        return list;
    }

    public List<NewsSaveDto> removeRepeat(List<NewsSaveDto> list){
        Iterator<NewsSaveDto> iterator = list.iterator();
        while(iterator.hasNext()){
            NewsSaveDto next = iterator.next();
            if(hrefFileter.mightContain(next.getHref())){
                //TODO 由于存在误判,所以需要再次进行准确的判断
                //如果已经存在，则删除
            }else{
                hrefFileter.put(next.getHref().hashCode());
            }
        }
        return null;
    }
}
