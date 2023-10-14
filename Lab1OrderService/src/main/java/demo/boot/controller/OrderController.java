package demo.boot.controller;

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
	  public ResponseEntity<Order>  placeOrder(@RequestBody Order order)
	  {
		  Order finalOrder = restTemplate.postForObject("http://localhost:8081", order, Order.class);
		  return ResponseEntity.ok().header("status", "successful").body(finalOrder);
	  }
	  
}
