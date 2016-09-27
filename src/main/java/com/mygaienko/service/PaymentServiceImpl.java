package com.mygaienko.service;

import com.mygaienko.model.PlaceOrderCommand;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

/**
 * Created by enda1n on 27.09.2016.
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Errors verifyPayment(PlaceOrderCommand command) {
        System.out.println("Verified Payment");
        return new BeanPropertyBindingResult(command, "Verified Payment");
    }
}
