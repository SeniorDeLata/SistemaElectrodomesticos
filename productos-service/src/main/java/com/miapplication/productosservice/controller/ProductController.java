package com.miapplication.productosservice.controller;

import com.miapplication.productosservice.model.Product;
import com.miapplication.productosservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productServ;

    @GetMapping("/list")
    public List<Product> getProducts(){
        return productServ.getProduct();
    }


    @GetMapping("/find/{id}")
    public Product findProductById(@PathVariable Long id){
        return productServ.findProductById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductById(@PathVariable Long id){
        productServ.deleteProduct(id);
        return "Product eliminated correctly";
    }
    @PostMapping("/save")
    public String saveProduct(@RequestBody Product p){
        productServ.saveProduct(p);
        return "Product created correctly";
    }

    @PutMapping("/edit/{id}")
    public Product editProduct(@PathVariable Long id,
                               @RequestBody Product p){
        return productServ.editProduct(id,p);
    }


}
