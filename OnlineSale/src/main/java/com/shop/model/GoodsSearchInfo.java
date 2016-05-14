package com.shop.model;

import java.util.List;

/**
 * Created by yuan on 16-5-14.
 */
public class GoodsSearchInfo {
    private String searchContent;
    private String classId;
    private Integer offset;
    private Integer size;
    private Integer page;
    private List<String> keywords;

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Integer getPage() {
        return page;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSize() {
        return size;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public String getClassId() {
        return classId;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSearchContent() {
        return searchContent;
    }

}
