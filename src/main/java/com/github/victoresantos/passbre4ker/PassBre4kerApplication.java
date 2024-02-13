package com.github.victoresantos.passbre4ker;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class PassBre4kerApplication {

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        String passToBreake = "pass"; //Para quebrar esta senha levou em media 25 segundos
        String pass = "";

        // ask for a input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the password to break: ");
        passToBreake = scanner.nextLine();
        Random random = new Random();

        do {
            pass = generateRandomString();
            System.out.println("Trying: " + pass);
        } while (!passToBreake.equals(pass));


        //diff between two localDatetime
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Time to break: " + duration.getSeconds() + " seconds");
    }

    //Este metodo pode gerar senhas duplicadas para testar,
    //portanto futuramente sera criado um novo metodo tentando ser mais eficiente
    private static String generateRandomString() {
        Random rnd = new Random();
        int range = rnd.nextInt(1,10);

        StringBuilder pass = new StringBuilder();

        char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

        while (pass.length() < range) {
            char c = characters[rnd.nextInt(0, characters.length)];
            pass.append(c);
        }
        return pass.toString();
    }
}
