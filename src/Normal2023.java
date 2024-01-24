import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Normal2023 {
    public static final int[][] arrayTemperatures = {
            {3, 5, 9, 3, 4, 5, 6, 9, 9, 7},
            {-8, 1, -8, 1, 5, 5, 5, 5, 5, 1},
            {7, -2, -2, 4, 4, 6, -2, 6, 7, 7},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
    };

    public static void main(String[] args) throws FileNotFoundException {
        int[] singleTemperaturesPerLine = getHowManySinglesTemperaturesPerLine();
        printArray1d(singleTemperaturesPerLine);
        printThermalHoles();
        saveLinesWithoutSingleTemperatures(singleTemperaturesPerLine);
    }

    //1
    public static int countSigleTemperatures(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (!verifyRepeatedInLine(array, i)) {
                count++;
            }
        }
        return count;
    }
    public static boolean verifyRepeatedInLine(int[] array, int i) {
        boolean repeated = false;
        for (int j = 0; j < array.length; j++) {
            if (j != i && array[i] == array[j]) {
                repeated = true;
                break;
            }
        }
        return repeated;
    }

    //2
    public static int[] getHowManySinglesTemperaturesPerLine() {
        int[] resultado = new int[arrayTemperatures.length];
        for (int linha = 0; linha < arrayTemperatures.length; linha++) {
            int[] array1d = transformLineToArray1d(linha);
            resultado[linha] = countSigleTemperatures(array1d);
        }
        return resultado;
    }

    public static int[] transformLineToArray1d(int linha) {
        int[] array1d = new int[arrayTemperatures[linha].length];
        for (int j = 0; j < arrayTemperatures[linha].length; j++) {
            array1d[j] = arrayTemperatures[linha][j];
        }
        return array1d;
    }
    //3
    public static void printThermalHoles() {
        boolean thereIsThermalHoles = false;
        for (int i = 1; i < arrayTemperatures.length - 1; i++) {
            for (int j = 1; j < arrayTemperatures[i].length - 1; j++) {
                if (arrayTemperatures[i][j] < arrayTemperatures[i - 1][j] && arrayTemperatures[i][j] < arrayTemperatures[i + 1][j]
                        && arrayTemperatures[i][j] < arrayTemperatures[i][j - 1] && arrayTemperatures[i][j] < arrayTemperatures[i][j + 1]) {
                    thereIsThermalHoles = true;
                    System.out.printf("Thermal hole : (%d,%d)%n", i, j);
                }
            }
        }
        if (!thereIsThermalHoles) {
            System.out.println("No Thermal holes");
        }
    }

    //4
    public static void saveLinesWithoutSingleTemperatures (int[] singleTemperaturesPerLine) throws FileNotFoundException {
        File file = new File("Normal2023Output/linesWithoutSingleTemperatures.txt");
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

    //extra
    public static void printArray1d(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}