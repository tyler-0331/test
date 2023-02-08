package com.tyler.test1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@RequestMapping("/Hello")
	public void hello() {
		System.out.println("Hey~ howdi?");
	}
}
