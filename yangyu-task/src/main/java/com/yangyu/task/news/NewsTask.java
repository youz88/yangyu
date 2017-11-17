package com.yangyu.task.news;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.yangyu.api.NewsApi;
import com.yangyu.common.Const;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.global.service.CacheService;
import com.yangyu.news.api.dto.NewsSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        for(int i=1;i<5;i++){
            List<NewsSaveDto> list = readData(i);
            newsApi.save(list);
        }
    }

    public List<NewsSaveDto> readData(Integer page){
        StringBuffer buffer = new StringBuffer("[");
        String filePath = NewsTask.class.getResource("/").getPath().substring(1)+fileName;
        String[] arg = new String[]{"python",filePath,page.toString()};
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
        return removeRepeat(list);
    }

    public List<NewsSaveDto> removeRepeat(List<NewsSaveDto> list){
        Iterator<NewsSaveDto> iterator = list.iterator();
        while(iterator.hasNext()){
            String nextHref = iterator.next().getHref();
            //使用布隆过滤器(由于存在误判,所以需要再次判断)
            if(hrefFileter.mightContain(nextHref) &&
                    cacheService.setIsMember(Const.NEWS_HREF,nextHref)){
                //如果已经存在，则删除
                iterator.remove();
                continue;
            }
            hrefFileter.put(nextHref);
            cacheService.set(Const.NEWS_HREF,nextHref);

        }
        return list;
    }


}
