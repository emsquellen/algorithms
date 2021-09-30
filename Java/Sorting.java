import java.util.Arrays;

public class Sorting {

    public static void insertionSort(int[] someArray) {

        for (int i = 1; i < someArray.length; i++) { // O(n)

            int currentValue = someArray[i]; // 1
            int pos = i; // 1
            while (pos > 0 && someArray[pos - 1] > currentValue) { // O(n) if the array is not sorted, else O(1)
                someArray[pos] = someArray[pos - 1]; // 1
                pos = pos - 1; // 1
            }
            someArray[pos] = currentValue; // 1
        }
    } // O(n) * O(n) = O(n^2) worst case, O(n) best case

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void selectionSort(int[] someArray) {
        for (int i = 0; i < (someArray.length - 1); i++) { // O(n)
            int min = i;
            for (int j = i + 1; j < someArray.length; j++) { // O(n)
                if (someArray[j] < someArray[min]) {
                    min = j;
                }
            }
            swap(someArray, i, min); // O(1)
        }
    } // O(n) * O(n) = O(n^2), so always O(n^2)

    // public static void doubleSelectionSort(int[] someArray) {
    // int n = someArray.length;
    // int min, max;
    // int left = 0;
    // int right = n - 1;

    // while (left <= right) { // O(n)
    // min = left;
    // max = right;

    // for (int i = left + 1; i < right; i++) { // O(n)
    // if (someArray[i] < someArray[min]) {
    // min = i;
    // }
    // }
    // if (min != left) {
    // swap(someArray, left, min);

    // }
    // for (int j = right - 1; j > left; j--) { // O(n)
    // if (someArray[j] > someArray[max]) {
    // max = j;
    // }
    // }
    // if (max != right) {
    // swap(someArray, right, max);

    // }
    // left++;
    // right--;
    // } // O(n)
    // }

    public static void bubbleSort(int[] someArray) {
        for (int i = 0; i < someArray.length - 1; i++) { // O(n)
            for (int j = 0; j < someArray.length - i - 1; j++) { // O(n)
                if (someArray[j] > someArray[j + 1]) {
                    swap(someArray, j, j + 1);
                }
            }
        }
    }

    public static void mergeSort(int[] someArray) {
        int left = 0;
        int right = someArray.length - 1;
        recursiveMergeSort(someArray, left, right);
    }

    private static void recursiveMergeSort(int[] someArray, int left, int right) {
        if (right > left) {
            int middle = left + (right - left) / 2;
            recursiveMergeSort(someArray, left, middle);
            recursiveMergeSort(someArray, middle + 1, right);
            merge(someArray, left, middle, right);
        }
    }

    private static void merge(int[] someArray, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = someArray[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = someArray[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while ((i < leftSize) && (j < rightSize)) {
            if (leftArray[i] <= rightArray[j]) {
                someArray[k] = leftArray[i];
                i++;
            } else {
                someArray[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            someArray[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            someArray[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] someArray) {
        int n = someArray.length - 1;
        recursiveQuickSort(someArray, 0, n);
    }

    public static void recursiveQuickSort(int[] someArray, int low, int high) {
        if (low < high) {
            int mid = partition(someArray, low, high);
            recursiveQuickSort(someArray, low, mid - 1);
            recursiveQuickSort(someArray, mid + 1, high);
        }
    }

    private static int partition(int[] someArray, int low, int high) {
        int pivot = someArray[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (someArray[j] <= pivot) {
                i++;
                swap(someArray, i, j);
            }
        }
        swap(someArray, i + 1, high);
        return i + 1;
    }

    public static void heapSort(int[] someArray) {
        int n = someArray.length;
        int mid = n / 2 - 1;
        for (int i = mid; i >= 0; i--) {
            heapify(someArray, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(someArray, 0, i);
            heapify(someArray, i, 0);
        }
    }

    private static void heapify(int[] someArray, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && someArray[left] > someArray[max]) {
            max = left;
        }
        if (right < n && someArray[right] > someArray[max]) {
            max = right;
        }
        if (max != i) {
            swap(someArray, i, max);
            heapify(someArray, n, max);

        }
    }

    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 48, 8, 78, 67, 7, 79, 21, 97, 29, 36, 19, 5, 63, 64, 10, 1, 20, 77, 28, 12, 98, 93, 54, 26, 37,
                73, 60, 88, 96, 82, 35, 2, 86, 66, 46, 9, 52, 45, 87, 22, 44, 25, 75, 4, 3, 69, 14, 32, 68, 92, 7, 79,
                21, 97, 29, 36, 19, 5, 63, 64, 10, 1, 20 };
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(isSorted(nums));

    }
}
