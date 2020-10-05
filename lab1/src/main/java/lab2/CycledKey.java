package lab2;

import java.util.function.Supplier;

public class CycledKey implements Supplier<String> {

    private final String keyToCycle;
    private final int lineLength;

    public CycledKey(final String keyToCycle, final int lineLength) {
        this.keyToCycle = keyToCycle;
        this.lineLength = lineLength;
    }

    @Override
    public String get() {
        StringBuilder sb = new StringBuilder(keyToCycle);
        while (sb.length() <= lineLength) {
            sb.append(keyToCycle);
        }
        sb.delete(lineLength, sb.length());
        return sb.toString().toUpperCase();
    }
}
