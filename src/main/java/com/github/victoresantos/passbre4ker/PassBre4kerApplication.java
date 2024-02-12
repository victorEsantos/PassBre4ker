package com.github.victoresantos.passbre4ker;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@SpringBootApplication
public class PassBre4kerApplication {

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        String passToBreake = "pass"; //Para quebrar esta senha levou em media 25 segundos
        String pass = "";

        do {
            pass = randomString(4);
            System.out.println("Trying: " + pass);
        } while (!passToBreake.equals(pass));


        //diff between two localDatetime
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Time to break: " + duration.getSeconds() + " seconds");
    }

    private static String randomString(int i) {
        //generate random string
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder pass = new StringBuilder();
        Random rnd = new Random();
        while (pass.length() < i) {
            int index = (int) (rnd.nextFloat() * characters.length());
            pass.append(characters.charAt(index));
        }
        return pass.toString();
    }
}
