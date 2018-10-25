package com.practice.main;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ApplicationInitializer implements ApplicationListener<ApplicationEvent> {
    private static final Logger log = LogManager.getLogger(ApplicationInitializer.class.getName());
    volatile boolean initialized = false; //volatile because it's unclear whether this event listener could be handled in parallel with various threads

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ContextRefreshedEvent && !initialized) {
            initialized = true;

            ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
            System.out.println("Beans loaded");
            System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
        }
    }
}
