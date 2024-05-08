package com.sasi.Amazoff;

public class Order {
    private String id;
    private String deliveryTime;

    public String getDeliveryTime() {
        return deliveryTime;
    }
    public Order() {
    }

    public Order(String id, String deliveryTime) {
        this.id = id;

        this.deliveryTime = deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
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
