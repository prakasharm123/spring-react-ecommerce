package com.telusko.springecom.service;

import com.telusko.springecom.entity.Product;
import com.telusko.springecom.exceptions.ProductNotFoundException;
import com.telusko.springecom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepo repo;

    @Override
    public List<Product> getProducts() {
        if(repo.findAll().isEmpty()){
            throw new ProductNotFoundException("Product not in DB");
        }
        return repo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> optional = repo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new ProductNotFoundException("Product not found with id " + id);
    }

    @Override
    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return repo.save(product);
    }

    @Override
    public String deleteProduct(Integer id) {
        repo.deleteById(id);
        return "Product with id "+id+" has been deleted";
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        return repo.searchProducts(keyword);
    }


}
