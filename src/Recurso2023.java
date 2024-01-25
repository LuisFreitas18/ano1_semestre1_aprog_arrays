
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Recurso2023 {
    public static String fileFlights = ("Recurso2023Input/flights.txt");
    public static int MAX_LINES = 72;
    public static int MAX_COLUMNS = 3;
    public static void main(String[] args) throws FileNotFoundException {
        String[] hours = new String[MAX_LINES];
        int[][] airstrips = new int[MAX_LINES][MAX_COLUMNS];
        readFlightsFromFile(fileFlights, hours, airstrips);
        System.out.println(getAirstripBusiest(airstrips));
        int[] allAirstripFlights = getAllAirstripFlights(airstrips);
        printArray1D(allAirstripFlights);
    }

    //1
    public static void readFlightsFromFile(String fileFlights, String[] hours, int[][] airstrips) throws FileNotFoundException {
        File file = new File(fileFlights);
        Scanner in = new Scanner(file);

        int countFlights = 0;
        while (in.hasNextLine()) {
            in.nextLine();
            countFlights++;
        }
        in = new Scanner(file);

        for (int i = 0; i < countFlights; i++) {
            if (in.hasNextInt()) {
                hours[i] = (in.nextInt()) + "h";
            }
            for (int j = 0; j < MAX_COLUMNS && in.hasNextInt(); j++) {
                airstrips[i][j] = in.nextInt();
            }
        }

        in.close();
    }

    //2
    public static int getAirstripBusiest(int[][] airstrips) {
        int busiestAirstrip = -1;
        int max = 0;
        for (int i = 0; i < airstrips.length; i++) {
            int moviment = airstrips[i][1] + airstrips[i][2];
            if (moviment >= max) {
                busiestAirstrip = airstrips[i][0];
            }
        }

        return busiestAirstrip;
    }

    //3
    public static int[] getAllAirstripFlights(int[][] airstrips) {
        int[] arrTotalPerAirstrip = new int[3];
        for (int i = 0; i < airstrips.length; i++) {
            int moviment = airstrips[i][1] + airstrips[i][2];
            switch (airstrips[i][0]) {
                case 1 :
                    arrTotalPerAirstrip[0] = moviment;
                case 2 :
                    arrTotalPerAirstrip[1] = moviment;
                case 3 :
                    arrTotalPerAirstrip[2] = moviment;
                default :
                    System.out.println("Error, invalid airstrip");
            }
        }

        return arrTotalPerAirstrip;
    }
    public static void printArray1D(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //4

}
