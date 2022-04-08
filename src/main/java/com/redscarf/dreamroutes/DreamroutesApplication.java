package com.redscarf.dreamroutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DreamroutesApplication {

    @Bean
    public FlywayMigrationStrategy cleanMigrationStrategy() {
        return flyway -> {
            flyway.repair();
            flyway.migrate();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DreamroutesApplication.class, args);
    }

}
