package com.xworkz.webmall.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/Mani")
public class MallComponent {

	public MallComponent() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onSend(@RequestParam String mallName, @RequestParam String deportment, @RequestParam int quantity,@RequestParam double price) {
		System.out.println("Running OnSend PostMaping.....");
		System.out.println("MallName :" + mallName);
		System.out.println("DeportmentMall :" + deportment);
		System.out.println("MallQuantity :" + quantity);
		System.out.println("Price :" + price);
		return "mall.jsp";
	}

}
