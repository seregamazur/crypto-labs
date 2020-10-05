package lab2;

import java.util.Scanner;

import lab2.model.Operation;
import lab2.model.dto.LineToProcessDto;

public class Dispatcher {

    public static void main(String[] args) {
        ValidationService validationService = new ValidationService();
        VigenereProcessor processor = new VigenereProcessor(validationService);
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Press 'E' to encrypt, 'D' to decrypt: ");
        final Operation operation = Operation.getByChoice(scanner.next().charAt(0));
        scanner.nextLine();
        System.out.println("Input your line");
        final String line = scanner.nextLine();
        System.out.println("Input your key");
        final String key = scanner.nextLine();
        System.out.println(processor.getProcessedLine(operation, new LineToProcessDto(line, key)));
    }

}
