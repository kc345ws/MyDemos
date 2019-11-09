package com.kc345ws.responsibilieychain;

//请求类
public class PurchassRequest {
    private int type;//请求类型
    public float price;
    private int id;

    public PurchassRequest(int type,float price,int id){
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
