package com.miapplication.productosservice;

import com.miapplication.productosservice.model.Product;
import com.miapplication.productosservice.service.IProductService;
import com.miapplication.productosservice.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductosServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(ProductosServiceApplication.class, args);
		ProductService ps = new ProductService();
		ps.loadDB();
	}
}
