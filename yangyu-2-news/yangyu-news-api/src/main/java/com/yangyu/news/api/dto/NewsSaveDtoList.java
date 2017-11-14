package com.yangyu.news.api.dto;

import com.yangyu.common.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by youz on 2017/11/14.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsSaveDtoList {

    private List<NewsSaveDto> newsSaveDtos;

    private String name;

    public List newsData(Class clazz){
        return JsonUtil.convertList(newsSaveDtos,clazz);
    }
}
