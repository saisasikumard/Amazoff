package com.sasi.Amazoff;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPartner {
    private String id;
    private List<String> orders=new ArrayList<>();
    public DeliveryPartner() {
    }

    public DeliveryPartner(String id,List<String> orders) {
        this.id = id;
        this.orders=orders;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
