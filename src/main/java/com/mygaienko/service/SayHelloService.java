package com.mygaienko.service;

import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 27.09.2016.
 */
@Service
public class SayHelloService {

    public void sayHello(String name){
        System.out.println("################################");
        System.out.println("################################");
        System.out.println("################################");
        System.out.println("##  Hello " + name + "!!!" );
        System.out.println("################################");
        System.out.println("################################");
        System.out.println("################################");
    }
}
