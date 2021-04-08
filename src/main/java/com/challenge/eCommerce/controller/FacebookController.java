package com.challenge.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.eCommerce.service.FacebookService;

@RestController
public class FacebookController {
	@Autowired
    private FacebookService facebookService;
	
	@GetMapping("/GenerateFacebookAuthorizeUrl")
	public String GenerateFacebookAuthorizeUrl() {
		return facebookService.generateFacebookAuthorizeUrl();
	}
	
	@GetMapping("/facebook")
	public void GenerateFacebookAccessToken(@RequestParam("code") String code) {
		facebookService.generateFacebookAccessToken(code);
	}
	
	@GetMapping("/facebook/getUserData")
	public String GetUserData() {
		return facebookService.getUserData();
	}
}
