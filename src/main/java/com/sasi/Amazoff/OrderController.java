package com.sasi.Amazoff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/add-order")
    public ResponseEntity addOrder(@RequestBody Order order){
        return new ResponseEntity(orderService.addOrder(order),HttpStatus.CREATED);

    }

    @PostMapping("/add-partner/{partnerId}")
    public ResponseEntity addPartner(@PathVariable("partnerId")  String id){
        return new ResponseEntity(orderService.addPartner(id),HttpStatus.CREATED);
    }

    @PutMapping("/add-order-partner-pair")
    public ResponseEntity orderToPartner(@RequestParam("orderId")String orderId,@RequestParam("partnerId") String partnerId){
        return new ResponseEntity(orderService.orderToPartner(orderId,partnerId),HttpStatus.ACCEPTED);

    }

    @GetMapping("/get-order-by-id/{orderId}")
    public ResponseEntity getOrder(@PathVariable("orderId") String id ){
            return  new ResponseEntity(orderService.getOrder(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-partner-by-id/{partnerId}")
    public ResponseEntity getPartner(@PathVariable("partnerId") String id){
        return new ResponseEntity(orderService.getPartner(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-order-count-by-partner-id/{partnerId}")
    public ResponseEntity getNumberOfOrders(@PathVariable("partnerId") String id){
        return new ResponseEntity(orderService.getNumberOfOrders(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-orders-by-partner-id/{partnerId}")
    public ResponseEntity getListOrdersForPartner(@PathVariable("partnerId") String id){
        return new ResponseEntity(orderService.getListOrdersForPartner(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-orders")
    public ResponseEntity getOrders(){
        return new ResponseEntity(orderService.getOrders(),HttpStatus.ACCEPTED);
    }

    //Get count of orders which are not assigned to any partner:
    @GetMapping("/get-count-of-unassigned-orders")
    public ResponseEntity getUnassigned(){
        return new ResponseEntity(orderService.getUnassigned(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-count-of-orders-left-after-given-time/{time}/{partnerId}")
    public ResponseEntity countOfOrderLeft(@PathVariable("time") String time,@PathVariable("partnerId") String pId){
        return new ResponseEntity(orderService.countOfOrderLeft(time,pId),HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete-partner-by-id/{partnerId}")
    public ResponseEntity deletePartner(@PathVariable("partnerId") String id){
        return new ResponseEntity(orderService.deletePartner(id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-order-by-id/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable("orderId") String oId){
        return new ResponseEntity(orderService.deleteOrder(oId),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-last-delivery-time/{partnerId}")
    public ResponseEntity lastDeliveryTime(@PathVariable("partnerId") String pId){
        return new ResponseEntity(orderService.lastDeliveryTime(pId),HttpStatus.ACCEPTED);
    }

}
