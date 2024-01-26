package com.miapplication.ventasservice.service;

import com.miapplication.ventasservice.dto.CarritoDTO;
import com.miapplication.ventasservice.dto.VentaDTO;
import com.miapplication.ventasservice.model.Venta;
import com.miapplication.ventasservice.repository.CarritoAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    public static List<Venta> ventaList = new ArrayList<>();

    @Autowired
    private CarritoAPI carroAPI;

    @Override
    public List<Venta> getVentas() {
        return ventaList;
    }

    @Override
    @CircuitBreaker(name="carrito-service", fallbackMethod = "fallbackFindVentaById")
    @Retry(name="carrito-service")
    public VentaDTO findVentaDTOById(Long id) {
        VentaDTO vDTO = new VentaDTO();
        Venta venta  = this.findVentaById(id);
            CarritoDTO cDTO = carroAPI.findCarritoById(venta.getId_carrito());
            vDTO.setCarrito(cDTO);
            vDTO.setId(venta.getId());
            vDTO.setFecha(venta.getFecha());
        return vDTO;
    }
    public VentaDTO fallbackFindVentaById(Throwable throwable){
        return new VentaDTO(null,null,null);
    }

    @Override
    public void saveVenta(Venta v) {
        v.setId(Long.parseLong((ventaList.size()+1)+""));
        ventaList.add(v);
    }

    @Override
    public void deleteVentaById(Long id) {
        List<Venta> listaDel = new ArrayList<>();
        for (Venta v:ventaList){
            if(!(v.getId().equals(id))){
                listaDel.add(v);
            }
        }
        ventaList=listaDel;
    }

    @Override
    public Venta editVenta(Long id_venta, Venta venta) {
        List<Venta> listaDel = new ArrayList<>();
        if(this.findVentaById(id_venta)!= null){
            this.deleteVentaById(id_venta);
            venta.setId(id_venta);
            ventaList.add(Integer.parseInt(id_venta-1+""),venta);
            return this.findVentaById(id_venta);
        }
        return null;
    }

    @Override
    public Venta findVentaById(Long id) {
        for(Venta v: ventaList){
            if(v.getId().equals(id)){
                return v;
            }
        }
        return null;
    }

    public void loadDB(){
        ventaList.add(new Venta(1L, LocalDate.of(2024,1,24),1L));
        ventaList.add(new Venta(2L, LocalDate.of(2024,1,23),2L));
    }

}
