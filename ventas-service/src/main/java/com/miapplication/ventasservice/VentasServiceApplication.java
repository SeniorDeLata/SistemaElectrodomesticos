package com.miapplication.ventasservice;

import com.miapplication.ventasservice.service.VentaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class VentasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentasServiceApplication.class, args);
		VentaService vs = new VentaService();
		vs.loadDB();
	}

}
