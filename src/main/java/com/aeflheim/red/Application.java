package com.aeflheim.red;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(CatalogRepository repository) {
        return a -> {
            List<String> names = Arrays.asList("High Performance Carburetors",
                "Precision Engine Pistons",
                "Turbocharger Kits",
                "Performance Exhaust Systems",
                "Racing Camshafts",
                "Lightweight Flywheels",
                "Adjustable Coilover Suspension Kits",
                "Brake Upgrade Packages",
                "Cold Air Intake Systems",
                "Short Throw Shifters",
                "Carbon Fiber Hoods",
                "Alloy Wheels",
                "Racing Seats",
                "Polyurethane Bushing Kits",
                "Silicone Radiator Hoses",
                "Performance Brake Pads",
                "Stainless Steel Exhaust Headers",
                "High Flow Fuel Injectors",
                "Limited Slip Differentials",
                "Engine Oil Coolers");

            repository.saveAll(names.stream().map(Catalog::new)
                .collect(Collectors.toList()));
        };
    }

}
