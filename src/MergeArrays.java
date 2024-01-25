import java.util.Scanner;
import static java.util.Arrays.sort;

public class MergeArrays {
    public static int[] arr1 = {5, 8, 9};
    public static int[] arr2 = {4, 7, 8};
    public static void main(String[] args) {
        printArray1D(useMethod(inputMethod(), arr1, arr2));
    }

    public static int[] mergeArraysV1(int[] arr1, int[] arr2, int[] arrResult) {
        int idxResult = 0;
        for (int idx1 = 0; idx1 < arr1.length; idx1++) {
            arrResult[idxResult++] = arr1[idx1];
        }
        for (int idx2 = 0; idx2 < arr2.length; idx2++) {
            arrResult[idxResult++] = arr2[idx2];
        }
        sort(arrResult);

        return arrResult;
    }
    public static int[] mergeArraysV2(int[] arr1, int[] arr2, int[] arrResult) {
        sort(arr1); sort(arr2);
        int idx1, idx2, idxResult;
        idx1 = idx2 = idxResult = 0;

        while (idx1 < arr1.length && idx2 < arr2.length) {
            if (arr1[idx1] < arr2[idx2]) {
                arrResult[idxResult++] = arr1[idx1++];
            } else {
                arrResult[idxResult++] = arr2[idx2++];
            }
        }
        while (idx1 < arr1.length) {
            arrResult[idxResult++] = arr1[idx1++];
        }
        while (idx2 < arr2.length) {
            arrResult[idxResult++] = arr2[idx2++];
        }

        return arrResult;
    }

    public static void printArray1D(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int inputMethod() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            option = sc.nextInt();
        } while (option != 1 && option != 2);

        return option;
    }

    public static int[] useMethod(int method, int[] arr1, int[] arr2) {
        int[] arrResult = new int[arr1.length + arr2.length];
        if (method == 1) {
            mergeArraysV1(arr1, arr2, arrResult);
        } else {
            mergeArraysV2(arr1, arr2, arrResult);
        }
        return arrResult;
    }
}
