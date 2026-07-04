package com.telusko.springecom.service;

import com.telusko.springecom.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    public List<Product> getProducts();
    public Product getProductById(Integer id);
    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException;

    public String deleteProduct(Integer id);

    List<Product> searchProduct(String keyword);
    //public Product deleteProduct(Integer id);



}
