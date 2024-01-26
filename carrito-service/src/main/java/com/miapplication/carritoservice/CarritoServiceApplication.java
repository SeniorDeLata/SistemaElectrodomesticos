package com.miapplication.carritoservice;

import com.miapplication.carritoservice.service.CarritoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CarritoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarritoServiceApplication.class, args);
		CarritoService cs = new CarritoService();
		cs.loadDB();
	}

}
