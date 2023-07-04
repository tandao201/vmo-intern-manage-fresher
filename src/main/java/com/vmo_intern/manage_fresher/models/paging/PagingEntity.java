package com.vmo_intern.manage_fresher.models.paging;

public class PagingEntity<T> {
    private int page;
    private int total;
    private T data;

    public PagingEntity() {
    }

    public PagingEntity(int page, int total, T data) {
        this.page = page;
        this.total = total;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PagingEntity{" +
                "page=" + page +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
