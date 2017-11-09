package com.yangyu.task.news;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by youz on 2017/11/9.
 */
@Component
public class NewsTask{

    @Value("${yangyu.news.fileName}")
    private String fileName;

    @Scheduled(cron = "0/10 * * * * ?")
    public void catchNews(){
        String filePath = NewsTask.class.getResource("/").getPath().substring(1)+fileName;
        String[] arg = new String[]{"python",filePath,"1"};
        BufferedReader br = null;
        InputStream is = null;
        try {
            is = Runtime.getRuntime().exec(arg).getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while((line=br.readLine())!=null){
                System.out.println(line);
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
    }

}
