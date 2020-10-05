package lab1;

public class CaesarEncodeUtils {

    public String get(final String text, final int key) {
        final Letters letters = Letters.getAlphabetTypeByLine(text);
        return LetterEncodingUtils.getEncodedLetters(text,
            new String(letters.getLetters()),
            letters.getShiftedLetters(key));
    }

}
