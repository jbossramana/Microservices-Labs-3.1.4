package demo.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import demo.boot.model.Order;

@RestController
public class OrderController {

@Autowired
 RestTemplate restTemplate;
 
@PostMapping
 public ResponseEntity<Order> createOrder(@RequestBody Order newOrder)
 {
	 Order order = restTemplate.postForObject("http://DISCOUNTSERVICE", newOrder, Order.class);
	 
	 return ResponseEntity.ok().header("status", "successful").body(order);
	 
 }
}
