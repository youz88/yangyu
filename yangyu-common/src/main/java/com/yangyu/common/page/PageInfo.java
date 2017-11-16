package com.yangyu.common.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> implements Serializable {

    private long total;
    private List<T> list;

    @SuppressWarnings("unchecked")
    public static <T> PageInfo<T> returnList(List<T> list) {
        if (list instanceof PageList) {
            return new PageInfo(((PageList) list).getTotal(), new ArrayList(list));
        } else {
            return new PageInfo(0, list);
        }
    }
}
