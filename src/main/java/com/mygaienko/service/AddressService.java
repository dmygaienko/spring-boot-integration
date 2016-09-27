package com.mygaienko.service;

import com.mygaienko.model.PlaceOrderCommand;
import org.springframework.validation.Errors;

/**
 * Created by enda1n on 27.09.2016.
 */
public interface AddressService {

    Errors verifyAddress(PlaceOrderCommand command);
}

