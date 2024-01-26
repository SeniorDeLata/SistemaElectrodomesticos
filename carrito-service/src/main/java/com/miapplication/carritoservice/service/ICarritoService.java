package com.miapplication.carritoservice.service;

import com.miapplication.carritoservice.dto.CarritoDTO;
import com.miapplication.carritoservice.model.Carrito;

import java.util.List;

public interface ICarritoService {
    public List<Carrito> getCarrito();

    public void saveCarrito(Carrito c);

    public void deleteCarrito(Long id);

    public void saveProductInCarrito(Long carrito_id, Long product_id);

    public void deleteProductInCarritoById(Long carrito_id, Long product_id);

    public Carrito editCarrito(Long id,Carrito c);

    public CarritoDTO findCarritoDTOById(Long id);

    public Carrito findCarritoById(Long id);

}

