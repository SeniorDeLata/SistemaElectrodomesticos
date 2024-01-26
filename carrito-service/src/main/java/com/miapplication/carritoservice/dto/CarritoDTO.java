package com.miapplication.carritoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDTO {
    private Long id;
    private Double total_price;
    private List<ProductDTO> productList;
}
