package com.shop.model;

public class Carriage {
    private Integer carriageid;

    private String carriagename;

    private Double firstprice;

    private String destination;

    private Integer firstnumber;

    private Integer nextnumber;

    private Double nextprice;

    public Integer getCarriageid() {
        return carriageid;
    }

    public void setCarriageid(Integer carriageid) {
        this.carriageid = carriageid;
    }

    public String getCarriagename() {
        return carriagename;
    }

    public void setCarriagename(String carriagename) {
        this.carriagename = carriagename == null ? null : carriagename.trim();
    }

    public Double getFirstprice() {
        return firstprice;
    }

    public void setFirstprice(Double firstprice) {
        this.firstprice = firstprice;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public Integer getFirstnumber() {
        return firstnumber;
    }

    public void setFirstnumber(Integer firstnumber) {
        this.firstnumber = firstnumber;
    }

    public Integer getNextnumber() {
        return nextnumber;
    }

    public void setNextnumber(Integer nextnumber) {
        this.nextnumber = nextnumber;
    }

    public Double getNextprice() {
        return nextprice;
    }

    public void setNextprice(Double nextprice) {
        this.nextprice = nextprice;
    }
}