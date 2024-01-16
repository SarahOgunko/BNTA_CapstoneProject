package com.example.RainforestRetail.services;import com.example.RainforestRetail.models.Order;import com.example.RainforestRetail.models.Product;import com.example.RainforestRetail.models.ProductOrder;import com.example.RainforestRetail.repositories.OrderRepository;import com.example.RainforestRetail.repositories.ProductOrderRepository;import com.example.RainforestRetail.repositories.ProductRepository;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.HashMap;import java.util.Map;@Servicepublic class ProductOrderService {    @Autowired    ProductOrderRepository productOrderRepository;    @Autowired    OrderRepository orderRepository;    @Autowired    ProductRepository productRepository;    @Autowired    OrderService orderService;    //create a Product order    public Order addProductsToOrder (long userId, Map<Long, Integer> basket) {        Order order = orderService.createOrder(userId);        for (Map.Entry<Long, Integer> entry : basket.entrySet()) {            Product product = productRepository.findById(entry.getKey()).get();            ProductOrder productOrder = new ProductOrder(entry.getValue(), product, order);            order.addToProductOrdersList(productOrder);        }        orderRepository.save(order);        return order;    }    // find user by id,    // find last order associated w said user - get orderId    // find productId from hashmap (key)    // set product & quantity for each  productOrder    // add productOrders to arraylist    // set arraylist of productOrders on previously located order (orderId)}