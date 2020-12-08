package lab6;

public class Dispatcher {

    public static void main(String[] args) {
        final ByteMultiplier multiplier = new ByteMultiplier(0x100, 0x11B);
        System.out.println("D4 * 02 = " + multiplier.getMultiplyFunction().apply("D4", "02"));
        System.out.println("BF * 03 = " + multiplier.getMultiplyFunction().apply("BF", "03"));
        System.out.println("53 * CA = " + multiplier.getMultiplyFunction().apply("53", "CA"));
        System.out.println("36 * 93 = " + multiplier.getMultiplyFunction().apply("36", "93"));
    }
}
