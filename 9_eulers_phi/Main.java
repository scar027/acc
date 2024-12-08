public class Main {

    // Function to return GCD of a and b
    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    // Function to calculate Euler's Totient function (phi)
    static int phi(int n) {
        int result = 1;  // Start with 1 because we will count numbers from 2 onwards.
        for (int i = 2; i < n; i++) {
            if (gcd(i, n) == 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        // Finding Phi for input n
        System.out.println(phi(n));
    }
}