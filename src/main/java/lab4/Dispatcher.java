package lab4;

import java.util.Arrays;

import static lab4.Formulas.gcd;
import static lab4.Formulas.gcdex;
import static lab4.Formulas.inverseElements;
import static lab4.Formulas.inverseElements2;
import static lab4.Formulas.phi;

public class Dispatcher {

    public static void main(String[] args) {
        System.out.println("gcd(20, 46) = " + gcd(20, 46));
        System.out.println("gcd(10, 21) = " + gcd(10, 21));
        System.out.println("gcd(15, 34) = " + Arrays.toString(gcdex(15, 34)));
        System.out.println("gcd(9, 41) = " + Arrays.toString(gcdex(9, 41)));
        System.out.println("inverse elements(15, 32) = " + inverseElements(15, 32));
        System.out.println("phi(43) = " + phi(43));
        System.out.println("phi(18) = " + phi(18));
        System.out.println("inverse elements2 (5, 21) = " + inverseElements2(5, 21));
        System.out.println("inverse elements2 (12, 25) = " + inverseElements2(12, 25));
    }


}
