package com.firsttry.vallabh.model;

public class panjabifoodmodel {
    String name;
    String price,descriptioin;
    Integer Imageurl;
    String pricetag;



    public panjabifoodmodel(String name, String price, Integer imageurl, String description,String pricetag) {
        this.name = name;
        this.price = price;
        this.Imageurl = imageurl;
        this.descriptioin= description;
        this.pricetag=pricetag;
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImageurl() {
        return Imageurl;
    }

    public void setImageurl(Integer imageurl) {
        Imageurl = imageurl;
    }


    public String getDescriptioin() {
        return descriptioin;
    }

    public void setDescriptioin(String descriptioin) {
        this.descriptioin = descriptioin;
    }

    public String getPricetag() {
        return pricetag;
    }

    public void setPricetag(String pricetag) {
        this.pricetag = pricetag;
    }
}