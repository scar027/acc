import java.util.Scanner;

public class Main {
  public static int MaxProductSubarray(int[] a){
    int prefix = 1;
    int suffix = 1;
    int ans = 1;
    int n = a.length;

    for (int i = 0; i < n; i++)
    {
      if(prefix == 0)prefix = 1;
      if(suffix == 0)suffix = 1;

      prefix *= a[i];
      suffix *= a[n - i - 1];

      ans = Math.max(ans, Math.max(prefix, suffix));
    }

    return ans;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter space-separated integers(elements of the array): ");
    String input = sc.nextLine();
    String[] inputArray = input.split(" ");

    int[] a = new int[inputArray.length];
    for (int i = 0; i < inputArray.length; i++){
      a[i] = Integer.parseInt(inputArray[i]);
    }
    
    System.out.println(MaxProductSubarray(a));
    sc.close();
  }
}