package com.miapplication.ventasservice.repository;

import com.miapplication.ventasservice.dto.CarritoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="carrito-service")
public interface CarritoAPI {
    @GetMapping("/carrito/find/{code}")
    public CarritoDTO findCarritoById(@PathVariable ("code") Long code);
}
