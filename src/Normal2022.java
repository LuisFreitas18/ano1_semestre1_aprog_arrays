import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Normal2022 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] musics = {"On my way", "Memories", "Perfect", "Havana"};
        double[][] info = {
                {201.6, 3.25},
                {189, 2.80},
                {256.8, 2.75},
                {202.8, 2.35}
        };
        System.out.println(findMostExpensiveMusic(musics, info));
        //sort(musics, info);
        System.out.printf("%.2fs%n", calculateBiggestDifference(info));
        writeToFile(musics, info);
    }

    //1
    public static String findMostExpensiveMusic(String[] musics, double[][] info) {
        int indexMostExpensive = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i][1] >= info[indexMostExpensive][1]) {
                indexMostExpensive = i;
            }
        }
        return musics[indexMostExpensive];
    }

    //2        Este é fodidinho, foi tudo chatgpt, nao entendi um crl
    public static void sort(String[] musics, double[][] info) {
        double[][]infoTemp = info.clone();
        Arrays.sort(info, Comparator.comparingDouble(column -> column[1]));
        if (Arrays.deepEquals(infoTemp, info)) {
            Arrays.sort(musics);
        }
    }

    //3
    public static double calculateBiggestDifference(double[][] info) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < info.length; i++) {
            if (info[i][0] < min) {
                min = info[i][0];
            }
            if (info[i][0] > max){
                max = info[i][0];
            }
        }
        return (max - min);
    }
    //4
    public static void writeToFile(String[] musics, double[][] info) throws FileNotFoundException{
        File file = new File("Normal2022Output/musics.txt");
        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 0; i < info.length; i++) {
            printWriter.print(musics[i]);
            printWriter.printf(" / %.2fs / %.2f€", info[i][0], info[i][1]);
            printWriter.println();
        }
        printWriter.close();
    }
}
