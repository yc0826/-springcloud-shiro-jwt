package com.haochen.consumer.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author YangChao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageBean implements Serializable {

    private Integer currentPage;

    private Integer pageSize = 10;

    private Integer start;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        if(start != null) {
            return start;
        }
        return (currentPage - 1) * pageSize;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
