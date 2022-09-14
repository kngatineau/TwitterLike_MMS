package com.gatineau.TwitterLike_MMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TwitterLikeMmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterLikeMmsApplication.class, args);
	}

}
