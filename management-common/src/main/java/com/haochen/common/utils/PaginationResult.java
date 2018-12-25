package com.haochen.common.utils;

import java.util.List;

/**
 * @author YangChao
 */
public class PaginationResult<T> {
    private int page;
    private long total;
    private String code = "0";
    private long count;
    private List<T> data;
    private List<T> rows;

    public PaginationResult(List<T> t,PageInfo pageInfo){
        this.rows=t;
        this.page = pageInfo.getPage();
        this.total = pageInfo.getTotal();
    }

    public PaginationResult(List<T> data,String code, long count) {
        this.code = code;
        this.count = count;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> t) {
        this.rows = t;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
