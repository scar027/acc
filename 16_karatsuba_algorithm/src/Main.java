import java.util.Scanner;
import java.math.BigInteger;

public class Main {
  public static BigInteger Karatsuba(BigInteger x, BigInteger y)
  {
    int n = Math.max(x.bitLength(), y.bitLength());
    
    if (n <= 2000) return x.multiply(y);

    int h = (n + 32) / 64 * 32;

    BigInteger mask = BigInteger.ONE.shiftLeft(h).subtract(BigInteger.ONE);
    BigInteger xLow = x.and(mask);
    BigInteger yLow = y.and(mask);
    BigInteger xHigh = x.shiftRight(h);
    BigInteger yHigh = y.shiftRight(h);

    BigInteger z0 = Karatsuba(xLow, yLow);
    BigInteger z1 = Karatsuba(xLow.add(xHigh), yLow.add(yHigh));
    BigInteger z2 = Karatsuba(xHigh, yHigh);

    BigInteger result = z2.shiftLeft(2 * h).add(z1.subtract(z2).subtract(z0).shiftLeft(h)).add(z0);
    return result;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the first number: ");
    BigInteger x = sc.nextBigInteger();
    System.out.print("Enter the second number: ");
    BigInteger y = sc.nextBigInteger();
    System.out.println("The product is: " + Karatsuba(x, y));
    sc.close();
  }
}