package com.example.indiasforestmatrix.Recyclerview;

public class POJO {

    String listitem;
    int imageId;
    String web;


    public String getListitem() {
        return listitem;
    }

    public void setListitem(String listitem) {
        this.listitem = listitem;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public  String getWEB(){return web;}


    public POJO(String listitem, int imageId, String web) {
        this.listitem = listitem;
        this.imageId = imageId;
        this.web = web;
    }
}
