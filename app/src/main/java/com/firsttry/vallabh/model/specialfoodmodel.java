package com.firsttry.vallabh.model;

public class specialfoodmodel {

    String name;

    Integer Imageurl;

    public specialfoodmodel(String name, Integer imageurl) {
        this.name = name;

        Imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Integer getImageurl() {
        return Imageurl;
    }

    public void setImageurl(Integer imageurl) {
        Imageurl = imageurl;
    }
}
