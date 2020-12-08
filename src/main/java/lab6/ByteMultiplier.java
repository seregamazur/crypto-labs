package lab6;


import java.util.function.BiFunction;

public class ByteMultiplier {

    private final int overflowValue;
    private final int modulusValue;

    public ByteMultiplier(final int overflowValue, final int modulusValue) {
        this.overflowValue = overflowValue;
        this.modulusValue = modulusValue;
    }

    public BiFunction<String, String, String> getMultiplyFunction() {
        return (x1, x2) -> Integer.toHexString(
            getMultipliedBytes(Integer.parseInt(x1, 16), Integer.parseInt(x2, 16)));
    }

    private int getMultipliedBytes(int x1, int x2) {
        int result = 0;
        while (x2 > 0) {
            if ((x2 & 1) > 0) {
                result = result ^ x1;
            }
            x2 = x2 >> 1;
            x1 = x1 << 1;
            if ((x1 & overflowValue) > 0) {
                x1 = x1 ^ modulusValue;
            }
        }
        return result;
    }

}
