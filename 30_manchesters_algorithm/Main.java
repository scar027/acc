public class Main {
  public static int manachersAlgorithm(String s, int N) {
    String str = getModifiedString(s, N);
    int len = (2 * N) + 1;
    int[] P = new int[len];
    int c = 0;
    int r = 0;
    int maxLen = 0;

    for (int i = 0; i < len; i++) {
      int mirror = (2 * c) - i;

      if (i < r) {
        P[i] = Math.min(r - i, P[mirror]);
      }

      int a = i + (1 + P[i]);
      int b = i - (1 + P[i]);
      while (a < len && b >= 0 && str.charAt(a) == str.charAt(b)) {
        P[i]++;
        a++;
        b--;
      }

      if (i + P[i] > r) {
        c = i;
        r = i + P[i];
        if (P[i] > maxLen) {
          maxLen = P[i];
        }
      }
    }
    return maxLen - 1; // Subtract 1 to account for the added '#' characters
  }

  public static String getModifiedString(String s, int N) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append("#");
      sb.append(s.charAt(i));
    }
    sb.append("#");
    return sb.toString();
  }

  public static void main(String args[]) {
    String str = "inputstring";
    System.out.println(manachersAlgorithm(str, str.length()));
  }
}
