package lab5;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Dispatcher {

    private final static SecureRandom RANDOM = new SecureRandom();

    private final BigInteger publicKey;
    private final BigInteger privateKey;
    private final BigInteger p;
    private final BigInteger q;
    private final BigInteger n;
    private final BigInteger phi;

    Dispatcher(int length) {
        this.p = new BigInteger("43");
        this.q = new BigInteger("127");
        this.n = p.multiply(q);
        this.phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        this.publicKey = new BigInteger("5");
        this.privateKey = publicKey.modInverse(phi);
    }

    BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, n);
    }

    BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(privateKey, n);
    }

    @Override
    public String toString() {
        return
            "p=" + p + "\n" +
                "q=" + q + "\n" +
                "n=" + n + "\n" +
                "privateKey=" + privateKey + "\n" +
                "publicKey=" + publicKey + "\n";
    }

    public static void main(String[] args) {
        int number = RANDOM.nextInt(30);
        Dispatcher dispatcher = new Dispatcher(number);
        System.out.println(dispatcher);

        BigInteger message = new BigInteger("2020");

        BigInteger encrypt = dispatcher.encrypt(message);
        BigInteger decrypt = dispatcher.decrypt(encrypt);
        System.out.println("Message = " + message);
        System.out.println("Encrypted message = " + encrypt);
        System.out.println("Decrypted message = " + decrypt);
    }

    private BigInteger getPublicKey(int length) {
        BigInteger publicKey = BigInteger.probablePrime(length, RANDOM);
        while (publicKey.compareTo(BigInteger.ONE) <= 0 || publicKey.compareTo(phi) >= 0) {
            publicKey = BigInteger.probablePrime(length, RANDOM);
        }
        return publicKey;
    }
}

//p=43
//    q=127
//    n=5461
//    privateKey=2117
//    publicKey=5
//
//    Message = 2020
//    Encrypted message = 3009
//    Decrypted message = 2020