package com.sasi.Amazoff;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    Map<String,Order> orderDB=new HashMap<>();
    Map<String,DeliveryPartner> deliveryPartnerDB=new HashMap<>();
    Map<String,String> orderPartnerDB=new HashMap<>();
    Map<String, List<String>> partnerOrderDB =new HashMap<>();

    int Assignedcount=0;

    public String addOrder(Order order) {
        if(orderDB.containsKey(order.getId())){
            return("Order already present...!");
        }
        orderDB.put(order.getId(),order);
        return "Order is added successfully..!";

    }

    public String addPartner(String id) {
        if(deliveryPartnerDB.containsKey(id)){
            return "Partner Already presented..";
        }
        deliveryPartnerDB.put(id,new DeliveryPartner());
        deliveryPartnerDB.get(id).setId(id);
        return "Partner Added succesfully";
    }

    public String orderToPartner(String orderId, String partnerId) {
        if(orderDB.containsKey(orderId)&& partnerOrderDB.containsKey(partnerId)){
            orderPartnerDB.put(orderId,partnerId);
            partnerOrderDB.put(partnerId,partnerOrderDB.get(partnerId));
            if(partnerOrderDB.get(partnerId)==null){
                partnerOrderDB.put(partnerId,new ArrayList<>());
//            partnerOrderDB.get(partnerId).add(orderId);
//            return "Order added to partner succesufuly";
            }
            partnerOrderDB.get(partnerId).add(orderId);
            deliveryPartnerDB.get(partnerId).getOrders().add(orderId);
            Assignedcount++;
            return "Order added to partner succesufuly";
        }
        return "order or partner not Found..!";

    }

    public Order getOrder(String id) {
        return orderDB.get(id);
    }

    public DeliveryPartner getPartner(String id) {
        return deliveryPartnerDB.get(id);
    }

    public List getListOrdersForPartner(String id) {
        return partnerOrderDB.get(id);
    }

    public Set<String> getOrders() {
        return orderDB.keySet();
    }

    public int getUnassigned() {
        int rem=orderDB.size()-Assignedcount;
        return rem;
    }


    public String deletePartner(String id) {
        if(deliveryPartnerDB.containsKey(id)){
            deliveryPartnerDB.remove(id);
           // orderPartnerDB.remove(orderPartnerDB.containsValue(id));
            orderPartnerDB.values().remove(id);
            partnerOrderDB.remove(id);
            Assignedcount--;
            return "Deleted the Partner from System succesfully";
        }
        return "No partner is there..!";

    }

    public int getNumberOfOrders(String id) {
        if (partnerOrderDB.containsKey(id)) {
            return partnerOrderDB.get(id).size();
        }
    return 0;
    }


    public String deleteOrder(String oId) {
        if(orderDB.containsKey(oId)){
            orderDB.remove(oId);
            orderPartnerDB.remove(oId);
            for(List<String> oList:partnerOrderDB.values()){
                if(oList.contains(oId)){
                    oList.remove(oId);
                }
            }
            return "Order deleted succesfully";

        }
        return "Order not found there.....!!";

    }
}
