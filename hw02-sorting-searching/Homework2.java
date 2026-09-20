import java.util.Arrays;

// Name: Bezhan Sangov
// Programming Language: Java
// IDE: VS Code

public class Homework2 {
    public static void main(String[] args) {
        int[] originalArr = {1, 3, 12, 7, 67, 78, 4, 56, 29, 91, 8, 34};
        int[] bubbleArr = Arrays.copyOf(originalArr, originalArr.length);
        int[] mergeArr = Arrays.copyOf(originalArr, originalArr.length);

        System.out.println("Original Array: ");
        printArr(originalArr);

        // Linear Search - run on UNSORTED array
        System.out.println("\nLinear Search");

        System.out.println("Target: 3"); // near beginning
        printSearchResult(linearSearch(originalArr, 3));

        System.out.println("Target: 34"); // near end
        printSearchResult(linearSearch(originalArr, 34));

        System.out.println("Target: 100"); // does not exist
        printSearchResult(linearSearch(originalArr, 100));

        // Bubble Sort
        bubbleSort(bubbleArr);
        System.out.println("\nBubble Sort Result: ");
        printArr(bubbleArr);

        // Merge Sort
        mergeArr = mergeSort(mergeArr);
        System.out.println("\nMerge Sort Result: ");
        printArr(mergeArr);

        // Binary Search - run on SORTED array
        System.out.println("\nBinary Search");

        System.out.println("Target: 1"); // near beginning
        printSearchResult(binarySearch(bubbleArr, 1));

        System.out.println("Target: 91"); // near end
        printSearchResult(binarySearch(bubbleArr, 91));

        System.out.println("Target: 100"); // does not exist
        printSearchResult(binarySearch(bubbleArr, 100));
    }

    public static void printArr(int[] arr) {
        for (int n: arr) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void printSearchResult(int result) {
        if (result == -1) {
            System.out.println("Target not found.");
        } else {
            System.out.printf("Target found at index: %d\n", result);
        }
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int tempVal;
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i+1]) {
                    tempVal = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tempVal;

                    swapped = true;
                }
            }
        }
    }

    // Merge Sort
    public static int[] mergeSort(int[] originalArr) {
        // base case: when an array has 0 or 1 elements it's already sorted
        if (originalArr.length <= 1) {return originalArr;}

        int mid = originalArr.length / 2;

        // split into left and right half, then recursively sort each half
        int[] leftArr = mergeSort(Arrays.copyOf(originalArr, mid));
        int[] rightArr = mergeSort(Arrays.copyOfRange(originalArr, mid, originalArr.length));

        // combine the two sorted halves into one array 
        return merge(leftArr, rightArr);
    }

    // Merge
    public static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length+right.length];
        int l = 0; int r = 0; // pointers for left and right arrays
        int resIdx = 0; // pointer for the merged sorted array

        // compare left[l] and right[r], and copy whatever is smaller into result array
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                res[resIdx] = left[l];
                l++;
            } else {
                res[resIdx] = right[r];
                r++;
            }
            resIdx++;
        }

        // I just realized that only one of this loops will run, since at least either 
        // left or right array has to be empty for the loop above to exit
        // so we can just copy everything straight to the result array, wo/ any comparison
        while (l < left.length) {
            res[resIdx] = left[l];
            resIdx++;
            l++;
        }
        while (r < right.length) {
            res[resIdx] = right[r];
            resIdx++;
            r++;
        }
        return res;
    }

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int med = (start + end) / 2;
            if (arr[med] == target) {
                return med;
            } else if (arr[med] > target) {
                end = med - 1;
            } else {
                start = med + 1;
            }
        }
        return -1;
    }
}

/*
Part 4 - Bubble Sort Big 0

Q1: What is the worst-case Big O time complexity of Bubble Sort?

        O(n^2)

Q2: Why does Bubble Sort have this time complexity?

        Worst case scenario would be when the array is sorted backwards.
        The outer loop has to run n times to bubble each element to its place.
        For the inner loop, every single time outer loop runs, inner loop 
        runs almost the entire array again, which could be n times again,
        so
        n * n = n^2

Q3: If Bubble Sort processes 10 elements, approximately
    how many comparisons could be required compared with 1,000 elements?

        for 10 elements about 100, because 10 * 10 = 100
        for 1,000 it would be approximately 1,000,000, because 1,000 * 1,000 = 1 
        
        So even though the number of elements grew 100x the number of
        operations grew to 10,000x
*/



/*
Part 6 - Compare Bubble Sort and Merge Sort

Q4: What is the Big O time complexity of Merge Sort?

        It's O(n * log(n))

Q5: Which algorithm generally performs better
    when the amount of data becomes very large?

        Merge Sort, since it's time complexity is O(n*(log n))
        The number of its operations grows slower 
        compared to Bubble Sort which it's time complexity is O(n^2)

Q6: Complete the following:

        Bubble Sort = O(n^2)
        Merge Sort = O(n * (log n))
*/


/*
Part 11 - Searching Questions

Q7: What is the Big O time complexity of Linear Search?

        It's O(n), because worst case scenario the target is at the end of the array
        So the algorithm has to loop through all the elements, that means the search time increases
        as the size of the array increases.

Q8: What is the Big O time complexity of Binary Search?

        O(log n). Each comparison eliminates half of the remaining array,
        so the search space shrinks exponentially. For an array of size n,
        it only takes about log2(n) comparisons to find the target, or determine
        it doesn't exist.

Q9: Why does Binary Search require sorted data?

        Binary Search works by comparing the target to the middle element
        and eliminating half the remaining elements based on that comparison.
        This only works if the data is sorted - sorting guarantees that everything
        on one side of the midpoint is smaller and everything on the other side is larger,
        so we know for certain which half the target could be in.

Q10: Which search would you use if the data were not sorted?

        Linear, because Binary doesn't work on unsorted values

Q11: Which search would generally be better for a very large sorted array?

        Binary, because of its time complexity
*/


/*
Part 12 - Algorithm Comparison Table

Algorithm       | Purpose    | Big O
Bubble Sort     | Sorting    | O(n^2)
Merge Sort      | Sorting    | O(n log n)
Linear Search   | Searching  | O(n)
Binary Search   | Searching  | O(log n)
*/