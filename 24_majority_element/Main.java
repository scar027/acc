import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
  public static int MajorityElement(int[] a){
    Map<Integer, Integer> mp = new HashMap<>();
    for(int i : a){
      mp.put(i, mp.getOrDefault(i, 0) + 1);
    }

    for(Map.Entry<Integer, Integer> entry : mp.entrySet())
    {
      if(entry.getValue() > a.length / 2) return entry.getKey();
    }
    return -1;
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
    
    System.out.println(MajorityElement(a));
    sc.close();
  }
  
}
