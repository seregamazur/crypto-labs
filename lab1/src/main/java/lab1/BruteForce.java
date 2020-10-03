package lab1;

import java.util.Scanner;

public class BruteForce {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your line: ");
        final String text = scanner.nextLine();
        for (int i = 0; i < 11; i++) {
            System.out.println(new CaesarEncodeUtils().get(text, i));
        }
    }
}
