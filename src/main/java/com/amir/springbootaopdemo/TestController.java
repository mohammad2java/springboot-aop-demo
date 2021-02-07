package com.amir.springbootaopdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	

	@GetMapping("/ping")
	public String pingWithName(@RequestParam("name") String name) {
		System.out.println("ping controller called");
		if (name.equals("exception"))
			throw new RuntimeException();

		return "Welcome "+name;
	}

}
