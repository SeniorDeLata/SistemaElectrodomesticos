package com.miapplication.carritoservice.service;

import com.miapplication.carritoservice.dto.CarritoDTO;
import com.miapplication.carritoservice.dto.ProductDTO;
import com.miapplication.carritoservice.model.Carrito;
import com.miapplication.carritoservice.repository.IProductoAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ModuleDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CarritoService implements ICarritoService{

    public static List<Carrito> carritoList = new ArrayList<>();

    @Autowired()
    private IProductoAPI productApi;

    @Override
    public List<Carrito> getCarrito() {
        return carritoList;
    }

    @Override
    public void saveCarrito(Carrito c) {
        c.setTotal_price(0.0);
        for(Long p : c.getProductList()){
            c.setTotal_price(productApi.findProductById(p).getPrice() + c.getTotal_price());
        }
        c.setId(Long.parseLong((carritoList.size()+1)+""));
        carritoList.add(c);
    }

    @Override
    public void deleteCarrito(Long id) {
        List<Carrito> listaDel = new ArrayList<>();
        for (Carrito c:carritoList){
            if(!(c.getId().equals(id))){
                listaDel.add(c);
            }
        }
        carritoList=listaDel;
    }

    @Override
    public void saveProductInCarrito(Long carrito_id, Long product_id) {
        Carrito c = this.findCarritoById(carrito_id);
        if(c!=null) {
            List<Long> productList = new ArrayList<>(c.getProductList());
            productList.add(product_id);
            c.setProductList(productList);
            this.editCarrito(c.getId(),c);
        }
    }

    @Override
    public void deleteProductInCarritoById(Long carrito_id, Long product_id) {
        Carrito c = this.findCarritoById(carrito_id);
        List<Long> productList = new ArrayList<>();
        if(c!=null) {
            for (Long p : c.getProductList()) {
                if (!Objects.equals(p, product_id)) {
                    productList.add(p);
                }
            }
            c.setProductList(productList);
            this.editCarrito(c.getId(),c);
        }
    }

    @Override
    public Carrito editCarrito(Long id, Carrito c) {
        List<Carrito> listaDel = new ArrayList<>();
        Carrito carritoFalse = new Carrito();
        carritoFalse.setTotal_price(null);
        if(this.findCarritoById(id)!= null){
            this.deleteCarrito(id);
            c.setId(id);
            carritoList.add(Integer.parseInt(id-1+""),c);
            c.setTotal_price(0.0);
            for(Long p : c.getProductList()){
                c.setTotal_price(productApi.findProductById(p).getPrice() + c.getTotal_price());
            }
            return this.findCarritoById(id);
        }
        return carritoFalse;
    }

    @Override
    @CircuitBreaker(name="productos-service", fallbackMethod = "fallbackFindCarritoByCode")
    @Retry(name="productos-service")
    public CarritoDTO findCarritoDTOById(Long id) {
        Carrito c =this.findCarritoById(id);
        CarritoDTO cDTO = new CarritoDTO();

        List<ProductDTO> productList = new ArrayList<>();
        cDTO.setId(c.getId());
        cDTO.setTotal_price(c.getTotal_price());
        for (Long p_id : c.getProductList()) {
            ProductDTO pDTO = productApi.findProductById(p_id);
            productList.add(pDTO);
        }
        cDTO.setProductList(productList);


        return cDTO;
    }

    @Override
    public Carrito findCarritoById(Long id) {
        for(Carrito c: carritoList){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    //PONER FALLBACKMETHOD
    public CarritoDTO fallbackFindCarritoByCode(Throwable throwable){
        return new CarritoDTO(null,100.0,null);
    }

    public void loadDB(){
        carritoList.add(new Carrito(1L,46000.0,List.of(1L,2L)));
        carritoList.add(new Carrito(2L,171000.0,List.of(1L,2L,5L)));
        carritoList.add(new Carrito(3L,100000.0,List.of(1L,3L,6L)));
    }

}
