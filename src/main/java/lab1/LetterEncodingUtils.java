package lab1;

public class LetterEncodingUtils {

    public static String getEncodedLetters(final String text, final String fromAlphabet, final String toAlphabet) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            final char c = text.charAt(i);
            sb.append(encodedLetter(fromAlphabet, toAlphabet, c));
        }
        return sb.toString();
    }

    private static char encodedLetter(final String fromAlphabet, final String toAlphabet, final char c) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }
        final char singleChar = toAlphabet.charAt(Character.toLowerCase(fromAlphabet.indexOf(Character.toLowerCase(c))));
        return Character.isUpperCase(c) ? Character.toUpperCase(singleChar) : singleChar;
    }
}
