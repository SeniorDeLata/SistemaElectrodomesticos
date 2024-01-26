package com.miapplication.ventasservice.service;

import com.miapplication.ventasservice.dto.VentaDTO;
import com.miapplication.ventasservice.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();

    public VentaDTO findVentaDTOById(Long id);

    public void saveVenta(Venta v);

    public void deleteVentaById(Long id);

    public Venta editVenta(Long id_venta,Venta venta);

    public Venta findVentaById(Long id);

}
