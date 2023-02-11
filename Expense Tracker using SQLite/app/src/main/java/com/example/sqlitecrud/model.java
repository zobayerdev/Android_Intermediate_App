package com.example.sqlitecrud;

public class model
{
  String name,quan,price;

    public model(String name, String quan, String price) {
        this.name = name;
        this.quan = quan;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
