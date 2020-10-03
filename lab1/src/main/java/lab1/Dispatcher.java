package lab1;

import java.util.Scanner;

public class Dispatcher {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your line: ");
        final String text = scanner.nextLine();
        System.out.println("And your key: ");
        final int key = scanner.nextInt();
        System.out.println(new CaesarEncodeUtils().get(text, key));
    }
}
