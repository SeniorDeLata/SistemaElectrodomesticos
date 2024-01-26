package com.miapplication.productosservice.service;

import com.miapplication.productosservice.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    public static List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> getProduct() {
        return productList;
    }

    @Override
    public void saveProduct(Product p) {
        p.setId(Long.parseLong((productList.size()+1)+""));
        productList.add(p);
    }

    @Override
    public void deleteProduct(Long id) {
       List<Product> listaDel = new ArrayList<>();
        for (Product p:productList){
            if(!(p.getId().equals(id))){
                listaDel.add(p);
            }
        }
        productList=listaDel;
    }

    @Override
    public Product editProduct(Long id, Product p) {
        List<Product> listaDel = new ArrayList<>();
        Product productFalse = new Product();
        productFalse.setName("Product not exist");
        if(this.findProductById(id)!= null){
            this.deleteProduct(id);
            p.setId(id);
            productList.add(Integer.parseInt(id-1+""),p);
            return this.findProductById(id);
        }
        return productFalse;
    }

    @Override
    public Product findProductById(Long id) {
        for(Product p: productList){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    //Logic DB
    public void loadDB(){
        productList.add(new Product(1L,"Lavadora","A00001",24000.0));
        productList.add(new Product(2L,"Secadora","A00002",22000.0));
        productList.add(new Product(3L,"Lava Platos","A00003",32000.0));
        productList.add(new Product(4L,"Horno/Cocina","A00004",159000.0));
        productList.add(new Product(5L,"Heladera","A00005",125000.0));
        productList.add(new Product(6L,"Ventilador","A00006",44000.0));
        productList.add(new Product(7L,"Mesa Estilo or.","A00007",14000.0));
        productList.add(new Product(8L,"Silla Estilo or.","A00008",7000.0));
    }
}
