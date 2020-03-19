package com.yangyu.common.page;

import java.util.ArrayList;
import java.util.Collection;

public class PageList<E> extends ArrayList<E> {
    private int total;

    public PageList() {
    }

    public PageList(Collection<? extends E> c, int total) {
        super(c);
        this.total = total;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}