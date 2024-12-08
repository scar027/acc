public class Main {

    public static void printMaxActivities(int[] start, int[] finish, int n) {
        System.out.println("Following activities are selected:");

        // The first activity is always selected
        int i = 0;
        System.out.print(i + " ");

        // Consider the rest of the activities
        for (int j = 1; j < n; j++) {
            // If the start time of the current activity is greater than or equal
            // to the finish time of the previously selected activity
            if (start[j] >= finish[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        printMaxActivities(start, finish, n);
    }
}
