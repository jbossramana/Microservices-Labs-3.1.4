package demo.boot.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.boot.model.Order;

@RestController
public class DiscountController {

	
	@PostMapping
	public Order  getDiscount( @RequestBody Order order)
	{
		System.out.println("DiscountService..2");
		
		if(order.getAmt() > 50000)
			order.setDiscount(500);
		else
			order.setDiscount(200);
		
		return order;
	}
}
