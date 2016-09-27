package com.mygaienko.service;

import com.mygaienko.model.PlaceOrderCommand;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

/**
 * Created by enda1n on 27.09.2016.
 */
@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
    @Override
    public Errors verifyInventory(PlaceOrderCommand command) {
        System.out.println("Verified Inventory");
        return new BeanPropertyBindingResult(command, "Verified Inventory");
    }
}
