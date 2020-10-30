package lab4;

public class Formulas {

    public Formulas() {
        throw new IllegalArgumentException("Utility class");
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    static long[] gcdex(long a, long b) {
        if (b == 0) {
            return new long[]{a, 1, 0};
        }
        long[] dxy = gcdex(b, a % b);
        return new long[]{dxy[0], dxy[2], dxy[1] - a / b * dxy[2]};
    }

    static long phi(long m) {
        int result = 1;
        for (int i = 2; i < m; i++) {
            if (gcd(i, m) == 1) {
                result++;
            }
        }
        return result;
    }

    static long inverseElements(long a, long m) {
        return gcdex(a, m)[1];
    }

    static long inverseElements2(long a, long m) {
        long k = 1;
        while ((m * k + 1) % a != 0) {
            ++k;
        }
        return (m * k + 1) / a;
    }

}
