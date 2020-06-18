package de.rappet.ispmap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class IspmapApplication {

    private static final Logger log = LoggerFactory.getLogger(IspmapApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(IspmapApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PtrRepository repository) {
        return (args) -> {
            // save a vew ptrs
            repository.save(new Ptr("10.0.0.1", "dummy1.lab.bb.rappet.xyz", LocalDateTime.now()));
            repository.save(new Ptr("10.0.0.2", "dummy2.lab.bb.rappet.xyz", LocalDateTime.now()));
            repository.save(new Ptr("10.0.0.3", "dummy3.lab.bb.rappet.xyz", LocalDateTime.now()));
            repository.save(new Ptr("10.0.0.4", "dummy4.lab.bb.rappet.xyz", LocalDateTime.now()));

            Ptr ptr = repository.findByIp("10.0.0.3");
            log.info("Customer found with findByIp(10.0.0.3):");
            log.info(ptr.toString());
        };
    }

}
