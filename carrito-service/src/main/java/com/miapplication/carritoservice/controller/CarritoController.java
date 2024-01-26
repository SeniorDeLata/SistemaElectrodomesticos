package com.miapplication.carritoservice.controller;

import com.miapplication.carritoservice.dto.CarritoDTO;
import com.miapplication.carritoservice.model.Carrito;
import com.miapplication.carritoservice.service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private ICarritoService carroServ;

    @GetMapping("/list")
    public List<Carrito> getCarrito(){
        return carroServ.getCarrito();
    }

    @GetMapping("/find/{id}")
    public CarritoDTO findCarritoDTOById(@PathVariable Long id){
        return carroServ.findCarritoDTOById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCarritoById(@PathVariable Long id){
        carroServ.deleteCarrito(id);
        return "Carrito eliminated correctly";
    }

    @PutMapping("/edit/{id}")
    public Carrito editCarrito(@PathVariable Long id,
                               @RequestBody Carrito c){
        return carroServ.editCarrito(id,c);
    }

    @PostMapping("/save")
    public String saveCarrito(@RequestBody Carrito c){
        carroServ.saveCarrito(c);
        return "Carrito saved correctly";
    }

    @PutMapping("/edit/deleteproduct")
    public String deleteProductInCarritoById(@RequestParam Long carrito_id,
                                               @RequestParam Long product_id){
        carroServ.deleteProductInCarritoById(carrito_id,product_id);
        return "Product deleted correctly";
    }

    @PutMapping("/edit/addproduct")
    public String addProductInCarritoById(@RequestParam Long carrito_id,
                                          @RequestParam Long product_id){
        carroServ.saveProductInCarrito(carrito_id,product_id);
        return "Product added correctly";
    }

    @GetMapping("/findById/{id}")
    public Carrito findCarritoById(@PathVariable Long id){
        return carroServ.findCarritoById(id);
    }

}
