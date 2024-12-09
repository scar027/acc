public class Main {
  static void moveHyphenInFront(char[] str) {
    int i = str.length - 1;
    for (int j = i; j >= 0; j--)
      if (str[j] != '-') {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
        i--;
      }
  }

  public static void main(String[] args) {
    char[] str = "Code- 4 -lyf".toCharArray();

    moveHyphenInFront(str);

    System.out.println(String.valueOf(str));
  }
}
