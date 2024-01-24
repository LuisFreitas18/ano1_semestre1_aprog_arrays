import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Normal2020 {
    static final String FICHEIRO = ("Normal2020Input/ocupacaoSala2020-01-14.txt");
    static final int NUM_FILAS = 24;
    static final int[] PRECOS = {20, 15, 10};
    static final int NUM_LUGARES = 30;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int[][] lugares;
        lugares = lerOcupacaoDaSala();
        System.out.printf("Bilheteira : %d€%n", calcularBilheteira(lugares));
        System.out.print("Insira a quantidade de bilhetes consecutivos : ");
        int quantidadeBilhetes = sc.nextInt();
        System.out.println();
        System.out.println("Fila Disponível : " + informarLugares(lugares, quantidadeBilhetes));
    }

    //1
    public static int countLines() throws FileNotFoundException {
        Scanner in = new Scanner(new File(FICHEIRO));
        int countLines = 0;
        while (in.hasNextLine()) {
            in.nextLine();
            countLines++;
        }
        in.close();
        return countLines;
    }
    public static int[][] lerOcupacaoDaSala() throws FileNotFoundException {
        int countLines = countLines();
        int[][] lugares = new int[countLines][NUM_LUGARES];

        Scanner in = new Scanner(new File(FICHEIRO));
        for (int i = 0; i < countLines; i++) {
            String line = in.nextLine();
            String[] lineSplitted = line.split(";");

            for (int j = 0; j < lugares[i].length; j++) {
                lugares[i][j] = Integer.parseInt(lineSplitted[j]);
            }
        }
        in.close();

        return lugares;
    }

    //2
    public static int calcularBilheteira(int[][] lugares) {
        int valorBilheteira = 0;
        for (int i = 0; i < lugares.length; i++) {
            int fila = lugares[i][0];
            int precoZona = -1;
            if (fila <= (NUM_FILAS / 3)) {
                 precoZona = PRECOS[0];
            } else if (fila <= 2*(NUM_FILAS / 3)) {
                //Não é preciso ser else if (fila > (NUM_FILAS / 3) && fila <= 2*(NUM_FILAS / 3)),
                //porque o "else if" significa que só passa para o próximo se o anterior não for true
                 precoZona = PRECOS[1];
            } else if (fila <= (NUM_FILAS)) {
                 precoZona = PRECOS[2];
            }

            for (int j = 1; j < lugares[i].length; j++) {
                if (lugares[i][j] == 1) {
                    valorBilheteira += precoZona;
                }
            }
        }

        return valorBilheteira;
    }

    //3
    public static int informarLugares(int[][] lugares, int quantidadeBilhetes) {
        int filaPossivel = -1;
        for (int i = lugares.length - 1; i > 0; i--) { //da fila mais longe para a mais proxima
            int countVagosConsecutivos = 1;
            for (int j = 1; j < NUM_LUGARES - 1; j++) {
                if (lugares[i][j] == 0 && lugares[i][j - 1] == 0) {
                    countVagosConsecutivos++;
                }
            }
            if (countVagosConsecutivos >= quantidadeBilhetes) {
                filaPossivel = lugares[i][0];
            }
        }
        return filaPossivel;
    }
}
