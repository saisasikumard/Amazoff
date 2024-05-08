package com.sasi.Amazoff;

import org.springframework.beans.factory.annotation.Autowired;
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
}
