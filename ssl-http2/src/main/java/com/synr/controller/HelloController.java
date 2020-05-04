package com.synr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping
	public String test() {
		return "Hello controller Resource loaded successfully!!";
	}
}