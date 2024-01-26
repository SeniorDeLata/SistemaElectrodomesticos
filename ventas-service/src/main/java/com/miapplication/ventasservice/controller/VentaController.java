package com.miapplication.ventasservice.controller;

import com.miapplication.ventasservice.dto.VentaDTO;
import com.miapplication.ventasservice.model.Venta;
import com.miapplication.ventasservice.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sells")
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

    @GetMapping("/find/{id}")
    public VentaDTO findById(@PathVariable Long id){
        return ventaServ.findVentaDTOById(id);
    }

    @GetMapping("/list")
    public List<Venta> getVentas(){
        return ventaServ.getVentas();
    }

    @PostMapping("/save")
    public String saveVenta(@RequestBody Venta v){
        ventaServ.saveVenta(v);
        return "Venta saved correctly";
    }

    @PutMapping("/edit/{id}")
    public Venta editVenta(@PathVariable Long id,
                           @RequestBody Venta v){
        return ventaServ.editVenta(id,v);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        ventaServ.deleteVentaById(id);
        return "Venta eliminated correctly";
    }

}
