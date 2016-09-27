package com.mygaienko.service;

import com.mygaienko.model.Product;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 27.09.2016.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProduct(String productId) {
        Product product = new Product();
        product.setProductId(productId);
        product.setDescription("Product from Production");

        return product;
    }
}
