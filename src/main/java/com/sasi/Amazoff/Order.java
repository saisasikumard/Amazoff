package com.sasi.Amazoff;

import java.util.ArrayList;

public class Order {
    private String id;
    private Integer deliveryTime;

    public int getDeliveryTime() {
        return deliveryTime;
    }
    public Order() {
    }

    public Order(String id, String deliveryTime) {
        this.id = id;
        String[] time=deliveryTime.split(":");

        this.deliveryTime = Integer.parseInt(time[0])*60+Integer.parseInt( time[1]);
    }

    public void setDeliveryTime(String deliveryTime) {
        String[] time=deliveryTime.split(":");

        this.deliveryTime = Integer.parseInt(time[0])*60+Integer.parseInt( time[1]);
    }

    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                '}';
    }
}
