package lab1;

import java.util.regex.Pattern;

public enum Letters {
    UA("абвгґдеєжзиіїйклмнопрстуфхцчшщьюя"),
    ENG("abcdefghijklmnopqrstuvwxyz");

    private final String letters;

    Letters(String letters) {
        this.letters = letters;
    }

    public String getLetters() {
        return letters;
    }

    public String getShiftedLetters(final int key) {
        final String letters = getLetters();
        return letters.substring(key) + letters.substring(0, key);
    }

    public static Letters getAlphabetTypeByLine(final String line) {
        return Pattern.matches(".*\\p{InCyrillic}.*", line)
            ? Letters.UA
            : Letters.ENG;
    }
}

