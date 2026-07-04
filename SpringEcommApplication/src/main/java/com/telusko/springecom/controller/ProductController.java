package com.telusko.springecom.controller;


import com.telusko.springecom.entity.Product;
import com.telusko.springecom.exceptions.ProductImageNotFoundException;
import com.telusko.springecom.exceptions.ProductNotFoundException;
import com.telusko.springecom.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products=service.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable Integer id){
        Product product = service.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile)  {
        Product addedProduct= null;
        try {
            addedProduct = service.addOrUpdateProduct(product,imageFile);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductImageById(@PathVariable Integer id){
        Product product = service.getProductById(id);
        if (Arrays.toString(product.getImageData()).isEmpty()) {
            throw new ProductImageNotFoundException("Image not Found with id :"+product.getId());
        }
        return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestPart Product product, @RequestPart MultipartFile imageFile)  {
        Product updatedProduct = null;
        try {
            updatedProduct = service.addOrUpdateProduct(product,imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>("updated",HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        Product product = service.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(service.deleteProduct(id),HttpStatus.OK);
        }
        throw new ProductNotFoundException("Product not Found with id :"+id);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(String  keyword){
        List<Product> products=service.searchProduct(keyword);
        System.out.println("searching with :" + keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }



}
