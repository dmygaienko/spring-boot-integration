package com.mygaienko.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by enda1n on 27.09.2016.
 */
@Configuration
@ImportResource("classpath*:si-config/order-si-config.xml")
public class OrderActiveMQConfig {

}
