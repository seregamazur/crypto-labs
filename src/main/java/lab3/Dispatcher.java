package lab3;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.NoSuchPaddingException;

import lab3.des.DesDecryptor;
import lab3.des.DesEncryptor;

public class Dispatcher {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Your line:");
        String line = scanner.nextLine();
        System.out.println("Your key (should be longer than 8 symbols) :");
        String key = scanner.nextLine();

        System.out.println("Encrypted line:");
        String encryptedLine = new DesEncryptor(line, key).get();
        System.out.println(encryptedLine);
        System.out.println("Decrypted line:");
        System.out.println(new DesDecryptor(encryptedLine, key).get());
    }

}
