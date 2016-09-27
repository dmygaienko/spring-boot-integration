package com.mygaienko.service;

import com.mygaienko.gateway.AddressGateway;
import com.mygaienko.gateway.InventoryGateway;
import com.mygaienko.gateway.OrderGateway;
import com.mygaienko.gateway.PaymentGateway;
import com.mygaienko.model.PlaceOrderCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by enda1n on 27.09.2016.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private AddressGateway addressGateway;
    @Autowired
    private InventoryGateway inventoryGateway;
    @Autowired
    private OrderGateway orderGateway;
    @Autowired
    private PaymentGateway paymentGateway;

    @Override
    public PlaceOrderCommand placeOrder(PlaceOrderCommand command) {
        Future<Errors> validateOrderErrorsFuture = orderGateway.validateOrder(command);
        Future<Errors> validateAddressErrorsFuture = addressGateway.verifyAddress(command);
        Future<Errors> validateInventoryErrorsFuture = inventoryGateway.verifyOrderInventory(command);
        Future<Errors> verifyCreditCardErrorsFuture = paymentGateway.verifyCreditCard(command);

        try {
            Errors validateOrderErrors = validateOrderErrorsFuture.get();
            Errors validateAddressErrors = validateAddressErrorsFuture.get();
            Errors validateInventoryErrors = validateInventoryErrorsFuture.get();
            Errors verifyCreditCardErrors = verifyCreditCardErrorsFuture.get();

            if (!validateOrderErrors.hasErrors() &&
                    !validateAddressErrors.hasErrors() &&
                    !validateInventoryErrors.hasErrors() &&
                    !verifyCreditCardErrors.hasErrors()) {
                return command;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return command;
    }

    @Override
    public Errors validateOrder(PlaceOrderCommand command) {
        System.out.println(Thread.currentThread().getId() + " : Validating Order.....");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() + " : Validating Order - DONE");
        return new BeanPropertyBindingResult(command, "Place Order Command");
    }
}
