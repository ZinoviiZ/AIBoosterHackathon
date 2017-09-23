package com.healthcare.innovation;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zinoviyzubko on 23.09.17.
 */
@ComponentScan("com.healthcare")
@SpringBootApplication
public class HealthcareInnovation {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareInnovation.class, args);
    }
}

