package com.example.lab9.Service;

import com.example.lab9.Model.Orders;
import com.example.lab9.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }


    public Orders getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }


    public Orders addOrder(Orders order) {
        return orderRepository.save(order);
    }


    public Orders updateOrder(Long id, Orders updatedOrder) {
        getOrderById(id);

        updatedOrder.setId(id);
        return orderRepository.save(updatedOrder);
    }


    public void deleteOrder(Long id) {
        Orders order = getOrderById(id);
        orderRepository.delete(order);
    }
}
