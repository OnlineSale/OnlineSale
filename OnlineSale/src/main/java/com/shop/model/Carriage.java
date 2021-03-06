package com.shop.model;

public class Carriage {
    private Integer carriageid;

    private String carriagename;

    private Double carriageprice;

    private String destination;

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

    public Double getCarriageprice() {
        return carriageprice;
    }

    public void setCarriageprice(Double carriageprice) {
        this.carriageprice = carriageprice;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }
}