package com.miapplication.ventasservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {
    private Long id;
    private LocalDate fecha;
    private CarritoDTO carrito;
}
