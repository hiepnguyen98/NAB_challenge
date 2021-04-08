package com.challenge.eCommerce.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;
@Service
public class FacebookService {
	private String accesstoken;
	@Value("${spring.social.facebook.appId}")
	private String facebookAppId;
	
	@Value("${spring.social.facebook.appSecret}")
	private String facebookSecret;
	
	private Facebook facebook;
	
	private FacebookConnectionFactory createConnection() {
		return new FacebookConnectionFactory(facebookAppId, facebookSecret);
	}
	
	public String generateFacebookAuthorizeUrl() {
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri("http://localhost:8080/facebook");
		params.setScope("email");
		return createConnection().getOAuthOperations().buildAuthenticateUrl(params);
	}
	
	
	public void generateFacebookAccessToken(String code) {
		accesstoken = createConnection().getOAuthOperations().exchangeForAccess(code, "http://localhost:8080/facebook", null).getAccessToken();
	}
	
	public String getUserData() {
		facebook = new FacebookTemplate(accesstoken);
        String [] fields = { "name","email","location","hometown"};
        return facebook.fetchObject("me", String.class, fields);
	}
}
