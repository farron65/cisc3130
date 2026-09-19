
import java.util.Arrays;

// Name: Bezhan Sangov
// Programming Language: Java
// IDE: VS Code

public class Homework2 {
    public static void main(String[] args) {
        int[] originalArr = {1, 3, 12, 7, 67, 78, 4, 56, 29, 91, 8, 34};

        System.out.println("Original Array: ");
        printArr(originalArr);

        // Linear Search - run on UNSORTED array
        System.out.println("\nLinear Search");

        System.out.println("Target: 3"); // near beginning
        System.out.printf("Target found at index: %d\n", linearSearch(originalArr, 3));

        System.out.println("Target: 34"); // near end
        System.out.printf("Target found at index: %d\n", linearSearch(originalArr, 34));

        System.out.println("Target: 100"); // does not exist
        System.out.printf("Target found at index: %d\n", linearSearch(originalArr, 100));

        // Sort the array
        bubbleSort(originalArr);
        System.out.println("\nAfter bubble sort");
        printArr(originalArr);

        // Binary Search - run on SORTED array
        System.out.println("\nBinary Search");

        System.out.println("Target: 1"); // near beginning
        System.out.printf("Target found at index: %d\n", binarySearch(originalArr, 1));

        System.out.println("Target: 91"); // near end
        System.out.printf("Target found at index: %d\n", binarySearch(originalArr, 91));

        System.out.println("Target: 100"); // does not exist
        System.out.printf("Target found at index: %d\n", binarySearch(originalArr, 100));
    }

    public static void printArr(int[] arr) {
        for (int n: arr) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

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

    public static int[] mergeSort(int[] originalArr) {
        if (originalArr.length <= 1) {return originalArr;}

        int mid = originalArr.length / 2;
        int[] leftArr = mergeSort(Arrays.copyOf(originalArr, mid));
        int[] rightArr = mergeSort(Arrays.copyOfRange(originalArr, mid, originalArr.length));

        return merge(leftArr, rightArr);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length+right.length];
        int l = 0; int r = 0;
        int resIdx = 0;

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

    public static int linearSearch(int[]arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

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
