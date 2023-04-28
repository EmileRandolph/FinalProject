package com.example.checkoutservice.restcontrollers;

import com.example.checkoutservice.objects.Order;
import com.example.checkoutservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderRestController {
    @Autowired
    private OrderRepository orderRepository;
    @PostMapping(path="")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createOrder(@RequestBody Order order){
        Order newOrder = new Order(order.getUserId(),order.getBasketId());
         orderRepository.save(newOrder);
    }
    @DeleteMapping(path = "/{orderID}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteItem(@PathVariable UUID orderID){
        orderRepository.deleteById(orderID);
    }

    @GetMapping(path = "")
    public List<Order> getAllOrders (){
        return orderRepository.findAll();
    }

    @GetMapping(path = "/{orderID}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Order> getOrderById(@PathVariable UUID orderID){
        return orderRepository.findById(orderID);
    }

}
