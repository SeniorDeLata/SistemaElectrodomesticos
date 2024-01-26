package com.miapplication.carritoservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carrito {
    private Long id;
    private Double total_price;
    private List<Long> productList;
}