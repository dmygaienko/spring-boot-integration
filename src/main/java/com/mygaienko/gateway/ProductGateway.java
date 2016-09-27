package com.mygaienko.gateway;

import com.mygaienko.model.Product;
import org.springframework.integration.annotation.Gateway;

/**
 * Created by enda1n on 27.09.2016.
 */
public interface ProductGateway {

    @Gateway(requestChannel = "getProductChannel")
    Product getProduct(String productId);
}
