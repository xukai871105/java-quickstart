package com.example;
import java.util.Scanner;

public class AppScanner {

    public static void main(String[] argv) {
        // Change the location through the Console
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String nextMove = scanner.next();
                System.out.println("recv: " + nextMove);
            }
        }
    }
}
