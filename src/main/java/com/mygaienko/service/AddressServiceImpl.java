package com.mygaienko.service;

import com.mygaienko.model.PlaceOrderCommand;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

/**
 * Created by enda1n on 27.09.2016.
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Override
    public Errors verifyAddress(PlaceOrderCommand command) {
        System.out.println("Verified Address");
        return new BeanPropertyBindingResult(command, "Verified Address");
    }
}
