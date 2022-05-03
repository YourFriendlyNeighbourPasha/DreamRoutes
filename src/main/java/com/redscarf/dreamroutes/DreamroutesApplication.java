package com.redscarf.dreamroutes;

import com.redscarf.dreamroutes.models.Driver;
import com.redscarf.dreamroutes.services.interfaces.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing
public class DreamroutesApplication implements CommandLineRunner {

    @Bean
    public FlywayMigrationStrategy cleanMigrationStrategy() {
        return flyway -> {
            flyway.repair();
            flyway.migrate();
        };
    }

    @Autowired
    private DriverService driverService;

    public static void main(String[] args) {
        SpringApplication.run(DreamroutesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Driver driver = new Driver();
//        driver.setBirthday(LocalDate.of(2002, 7, 12));
//        driver.setEmployedOn(LocalDate.of(2022, 2, 1));
//        driver.setFirstName("Pavlo");
//        driver.setLastName("Shcherbatyi");
//        driver.setMiddleName("Vasylyovich");
//
//        System.out.println(driver);
//        driverService.save(driver);
        System.out.println(driverService.findAll(0, 10).stream().findFirst().orElse(new Driver()));
    }
}
