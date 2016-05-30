package com.shop.model;

public class Comment {
    private Integer commentid;

    private Integer goodid;

    private Integer userid;

    private String content;

    private String commenttime;

    private Integer goodserver;

    private Integer sellerserver;

    private String logisticsserver;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime == null ? null : commenttime.trim();
    }

    public Integer getGoodserver() {
        return goodserver;
    }

    public void setGoodserver(Integer goodserver) {
        this.goodserver = goodserver;
    }

    public Integer getSellerserver() {
        return sellerserver;
    }

    public void setSellerserver(Integer sellerserver) {
        this.sellerserver = sellerserver;
    }

    public String getLogisticsserver() {
        return logisticsserver;
    }

    public void setLogisticsserver(String logisticsserver) {
        this.logisticsserver = logisticsserver == null ? null : logisticsserver.trim();
    }
}