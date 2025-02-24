import java.util.Arrays;

public class Main
{
    // O(1) - Constant time
    public static int O1(int[] arr)
    {
        return arr[0]; // Always returns the first element
    }// end O(1)


    // O(log n) - Binary Search
    public static int OLogN(int[] arr, int target)
    {
        int left = 0, right = arr.length - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }// end while loop
        return -1; // Target not found
    }// O(log n)


    // O(n) - Find maximum element
    public static int ON(int[] arr)
    {
        return Arrays.stream(arr).max().orElse(Integer.MIN_VALUE); // Using Java Streams
    }//  end O(n)


    // O(n log n) - Merge Sort
    public static void ONLogN(int[] arr)
    {
        Arrays.sort(arr); // Uses Dual-Pivot QuickSort (average O(n log n))
    }// O(n log n) - Merge Sort


    // O(n²) - Bubble Sort
    public static void ON2(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }// end if statement
            }// end nested for loop
        }// end first for loop
    }// O(n²) - Bubble Sort


    // O(2^n) recursion
    public static int O2N(int n)
    {
        if (n <= 1) return n;
        return O2N(n - 1) + O2N(n - 2);
    }// end  O(2^n) recursion

    // O(n!) permutations
    public static void ONFact(String str, String perm)
    {
        if (str.isEmpty())
        {
            System.out.println(perm);
            return;
        }// end if statement
        for (int i = 0; i < str.length(); i++)
        {
            ONFact(str.substring(0, i) + str.substring(i + 1), perm + str.charAt(i));
        }// end for looop
    }// O(n!) permutations

    public static void main(String[] args)
    {
        int[] arr = {5, 3, 8, 6, 2};

        System.out.println("O(1) result: " + O1(arr));

        int searchResult = OLogN(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
        System.out.println("O(log n) result: " + (searchResult != -1 ? "Found at index " + searchResult : "Not found"));

        System.out.println("O(n) result (max element): " + ON(arr));

        int[] arrMergeSort = arr.clone();
        ONLogN(arrMergeSort);
        System.out.println("O(n log n) Sorted Array: " + Arrays.toString(arrMergeSort));

        int[] arrBubbleSort = arr.clone();
        ON2(arrBubbleSort);
        System.out.println("O(n²) Sorted Array: " + Arrays.toString(arrBubbleSort));

        System.out.println("O(2^n) Fibonacci(5): " + O2N(5));

        System.out.println("O(n!) Permutations of 'ABC':");
        ONFact("ABC", "");
    }// end main meth
}// end class
