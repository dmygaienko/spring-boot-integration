package com.mygaienko.gateway;

import com.mygaienko.model.PlaceOrderCommand;
import org.springframework.integration.annotation.Gateway;
import org.springframework.validation.Errors;

import java.util.concurrent.Future;

/**
 * Created by enda1n on 27.09.2016.
 */
public interface OrderGateway {

    @Gateway(requestChannel = "placeOrderChannel")
    PlaceOrderCommand placeOrder(PlaceOrderCommand command);

    @Gateway(requestChannel = "validateOrderChannel")
    Future<Errors> validateOrder(PlaceOrderCommand command);
}
