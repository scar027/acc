// import java.util.*;

public class Main {
  static void moveHyphenInFront(char[] str) {
    int i = str.length - 1;

    // Move non-hyphen characters to the end of the array
    for (int j = i; j >= 0; j--) {
      if (str[j] != '-') {
        str[i--] = str[j];
      }
    }

    // Fill the remaining positions with hyphens
    while (i >= 0) {
      str[i--] = '-';
    }
  }

  public static void main(String[] args) {
    char[] str = "Code- 4 -lyf".toCharArray();

    moveHyphenInFront(str);

    System.out.println(String.valueOf(str));
  }
}
