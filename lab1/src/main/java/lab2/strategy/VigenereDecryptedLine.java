package lab2.strategy;

import lab2.model.LineToProcess;

public class VigenereDecryptedLine extends VigenereStrategy {

    public VigenereDecryptedLine(final LineToProcess line) {
        super(line);
    }

    @Override
    public String processedLine() {
        StringBuilder processedLine = new StringBuilder();
        for (int i = 0, j = 0; i < getLineToProcess().length(); i++) {
            char c = getLineToProcess().charAt(i);
            if (Character.isWhitespace(c)) {
                processedLine.append(c);
                continue;
            } else if (c < 'A' || c > 'Z') {
                continue;
            }
            processedLine.append((char) ((c - getKey().charAt(j) + 26) % 26 + 'A'));
            j = ++j % getKey().length();
        }
        return processedLine.toString();
    }

}
