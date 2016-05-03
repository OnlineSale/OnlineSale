package com.shop.model;

public class SubCategory {
    private Integer subcategoryid;

    private Integer categoryid;

    private String subcategoryname;

    private String subcategorydesc;

    private String createtime;

    public Integer getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(Integer subcategoryid) {
        this.subcategoryid = subcategoryid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getSubcategoryname() {
        return subcategoryname;
    }

    public void setSubcategoryname(String subcategoryname) {
        this.subcategoryname = subcategoryname == null ? null : subcategoryname.trim();
    }

    public String getSubcategorydesc() {
        return subcategorydesc;
    }

    public void setSubcategorydesc(String subcategorydesc) {
        this.subcategorydesc = subcategorydesc == null ? null : subcategorydesc.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}