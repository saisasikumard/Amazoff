package com.sasi.Amazoff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public String addOrder(Order order) {

        return orderRepository.addOrder(order);
    }

    public String addPartner(String id) {
        return orderRepository.addPartner(id);
    }

    public String orderToPartner(String orderId, String partnerId) {


        return orderRepository.orderToPartner(orderId,partnerId);
    }

    public Order getOrder(String id) {
        return orderRepository.getOrder(id);
    }

    public DeliveryPartner getPartner(String id) {
        return orderRepository.getPartner(id);
    }

    public int getNumberOfOrders(String id) {
        return  orderRepository.getNumberOfOrders(id);

    }

    public List getListOrdersForPartner(String id) {
        return orderRepository.getListOrdersForPartner(id);
    }

    public Set<String> getOrders() {
        return orderRepository.getOrders();
    }

    public int getUnassigned() {
        return orderRepository.getUnassigned();
    }

    public String deletePartner(String id) {
        return orderRepository.deletePartner(id);
    }

    public String deleteOrder(String oId) {
        return orderRepository.deleteOrder(oId);
    }

    public Integer countOfOrderLeft(String time, String pId) {
        String[] times=time.split(":");
        int checkTime= Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);
        return orderRepository.countOfOrderLeft(checkTime,pId);
    }

    public String lastDeliveryTime(String pId) {
        int time=orderRepository.lastDeliveryTime(pId);
        String HH=String.valueOf(time/60);
        String MM=String.valueOf(time%60);
        if(Integer.parseInt(HH)<10){
            HH="0"+HH;
        }
        if(Integer.parseInt(MM)<10){
            MM="0"+MM;
        }
        return (HH+":"+MM);

    }
}
