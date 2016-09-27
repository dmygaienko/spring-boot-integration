package com.mygaienko.service;

import com.mygaienko.gateway.OrderGateway;
import com.mygaienko.model.PlaceOrderCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by enda1n on 27.09.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderGateway orderGateway;

    @Test
    public void testPlaceOrder() throws Exception {
        orderGateway.placeOrder(new PlaceOrderCommand());
    }
}