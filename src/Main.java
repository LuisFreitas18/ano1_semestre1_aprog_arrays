import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static final int[][] arrayTemperatures = {
            {3, 5, 9, 3, 4, 5, 6, 9, 9, 7},
            {-8, 1, -8, 1, 5, 5, 5, 5, 5, 1},
            {7, -2, -2, 4, 4, 6, -2, 6, 7, 7},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
    };

    public static void main (String[] args) throws FileNotFoundException {
        int[] singleTemperaturesPerLine = getHowManySinglesTemperaturesPerLine();
        printArray1d(singleTemperaturesPerLine);
        saveLinesWithoutSingleTemperatures(singleTemperaturesPerLine);
    }

    //1
    public static int countSigleTemperatures(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean repeated = false;
            for (int j = 0; j < array.length; j++) {
                if (j != i && array[i] == array[j]) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated) {
                count++;
            }
        }
        return count;
    }

    //2
    public static int[] getHowManySinglesTemperaturesPerLine() {
        int[] resultado = new int[arrayTemperatures.length];
        for (int linha = 0; linha < arrayTemperatures.length; linha++) {
            int[] array1d = new int[arrayTemperatures[linha].length];
            for (int j = 0; j < arrayTemperatures[linha].length; j++) {
                array1d[j] = arrayTemperatures[linha][j];
            }
            resultado[linha] = countSigleTemperatures(array1d);
        }
        return resultado;
    }

    //3
    public static void printThermalHoles() {

    }

    //4
    public static void saveLinesWithoutSingleTemperatures (int[] singleTemperaturesPerLine) throws FileNotFoundException {
        File file = new File("linesWithoutSingleTemperatures.txt");
        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 0; i < singleTemperaturesPerLine.length; i++) {
            if (singleTemperaturesPerLine[i] == 0) {
                for (int j = 0; j < arrayTemperatures[i].length; j++) {
                    printWriter.print(arrayTemperatures[i][j] + " ");
                }
                printWriter.println();
            }
        }
        printWriter.close();
    }


    public static void printArray1d(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}