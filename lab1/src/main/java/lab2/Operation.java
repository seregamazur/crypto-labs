package lab2;

public enum Operation {
    ENCRYPT('E'),
    DECRYPT('D');

    private final char choice;

    Operation(final char choice) {
        this.choice = choice;
    }

    public static Operation getByChoice(final char choice) {
        if (choice == 'E') {
            return ENCRYPT;
        }
        return DECRYPT;
    }

    public char getChoice() {
        return choice;
    }
}
