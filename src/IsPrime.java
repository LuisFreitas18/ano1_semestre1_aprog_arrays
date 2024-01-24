import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            num = sc.nextInt();
            tellIfIsPrime(num);
        } while (num >= 0);
    }
    public static boolean verifyIsPrime(int num) {
        if (num <= 1) {
            return false;
        }

        int count = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        if (count == 1) {
            return true;
        }
        return false;
    }
    public static void tellIfIsPrime(int num) {
        if (verifyIsPrime(num)) {
            System.out.println(num + " : Prime");
        } else {
            System.out.println(num + " : Not Prime");
        }
    }
}
