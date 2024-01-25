import java.util.Scanner;
public class SearchArray_divide_by_2 {
    public static final int[] array = {10, 14, 19, 26, 27, 33, 33, 35, 42, 44};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int result = searchInArray(array, input);
        printResult(result);
    }
    public static int searchInArray(int[] array, int input) {
        int first = 0;
        int last = array.length - 1;
        while (first <= last) {
            int middle = (first + last) / 2;
            if (input < array[middle]) {
                last = middle - 1;
            } else if (input > array[middle]) {
                first = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
    public static void printResult(int result) {
        if (result == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found. Index : " + result);
        }
    }
}
