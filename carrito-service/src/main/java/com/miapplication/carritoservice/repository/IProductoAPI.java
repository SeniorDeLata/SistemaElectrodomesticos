package com.miapplication.carritoservice.repository;

import com.miapplication.carritoservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="productos-service")
public interface IProductoAPI {
    @GetMapping("/product/find/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id);
}
