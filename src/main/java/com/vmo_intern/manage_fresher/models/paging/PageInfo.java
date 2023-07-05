package com.vmo_intern.manage_fresher.models.paging;

import com.alibaba.fastjson.JSON;

public class PageInfo {
    private int page;
    private int pageSize;

    private long total;

    public PageInfo() {
    }

    public PageInfo(int page, int pageSize, long total) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
