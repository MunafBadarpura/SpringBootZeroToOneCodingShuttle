package org.rudradcruze.aliceandherbakery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AliceAndHerBakeryApplication implements CommandLineRunner {

    @Autowired
    CakeBaker cakeBaker;

    public static void main(String[] args) {
        SpringApplication.run(AliceAndHerBakeryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to Alice's Bakery");
        cakeBaker.bakeCake();
    }
}
