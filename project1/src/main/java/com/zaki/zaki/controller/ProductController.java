package com.zaki.zaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zaki.zaki.model.Product;
import com.zaki.zaki.model.Voucher;
import com.zaki.zaki.repository.ProductRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${voucherService.url}")
    private String voucherServiceUrl;

    @GetMapping()
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getOneProduct(@PathVariable("id") long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        Voucher voucher = restTemplate.getForObject(voucherServiceUrl + product.getVoucherCode(), Voucher.class);
        product.setPrice(product.getPrice().subtract(voucher.getDiscount()));
        return productRepository.save(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        Product productToUpdate = productRepository.findById(id).get();
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        return productRepository.save(productToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id) {
        productRepository.deleteById(id);
    }
}
