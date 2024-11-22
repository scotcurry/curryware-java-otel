package org.curryware.currywarejavaotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrywareJavaOtelApplication implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(CurrywareJavaOtelApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(CurrywareJavaOtelApplication.class, args);
    }
    
    @Override
    public void run (ApplicationArguments args) {

        logger.info("Curryware Otel Application started");
    }
}
