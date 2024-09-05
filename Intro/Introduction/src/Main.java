import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        String[][] tablica6 = new String[][] {
                { "100", "222" },
                { "3333", "44" },
                { "555", "6" },
                { "7", "888" }
        };
        int wynik = 0;
        for (int i = 0; i < tablica6.length; i++) {
            for (int j = 0; j < tablica6[i].length; j++) {
                int current_number = Integer.parseInt(tablica6[i][j]);
                wynik += current_number;
            }
        }
        System.out.println("Wynik: " + wynik);
    }
}