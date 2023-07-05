package com.vmo_intern.manage_fresher.models.paging;

import com.alibaba.fastjson.JSON;

public class PagingEntity<T> {
    private T data;
    private PageInfo page;

    public PagingEntity() {
    }

    public PagingEntity(T data, PageInfo page) {
        this.data = data;
        this.page = page;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
