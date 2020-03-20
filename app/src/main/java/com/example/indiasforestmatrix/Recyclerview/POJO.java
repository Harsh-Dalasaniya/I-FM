package com.example.indiasforestmatrix.Recyclerview;

public class POJO {

    String listitem;
    int imageId;


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


    public POJO(String listitem, int imageId) {
        this.listitem = listitem;
        this.imageId = imageId;
    }
}
