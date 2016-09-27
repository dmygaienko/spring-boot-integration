package com.mygaienko.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by enda1n on 27.09.2016.
 */
@Configuration
@Import(ActiveMQConfig.class)
@ComponentScan(basePackages = "com.mygaienko.service")
public class GeneralConfig {

}
