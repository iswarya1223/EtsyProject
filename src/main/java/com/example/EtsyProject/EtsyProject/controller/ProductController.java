package com.example.EtsyProject.EtsyProject.controller;

import com.example.EtsyProject.EtsyProject.entity.Products;
import com.example.EtsyProject.EtsyProject.service.ProductService;
import com.example.EtsyProject.EtsyProject.service.requests.SearchProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //display the product details based on the products given in the search query
    @PostMapping("/getSearchDetails/{keyword}")
    public List<Products> searchProducts(@RequestBody SearchProductRequest searchProductRequest,
                                      @PathVariable String keyword){

        return productService.searchProducts(searchProductRequest, keyword);
    }

    //display the product details based on the products given in the search query
    @GetMapping("/getProductDetail/{productid}")
    public Optional<Products> getProductDetail(@PathVariable Integer productid) throws Exception{
        return productService.getProductDetail(productid);
    }

    @GetMapping("/test")
    public String hello(){
        return "hello";
    }
}
