import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj string do odwrócenia: ");

        String input = scanner.nextLine();
        String reversed_string = "";
        int input_length = input.length();

        for (int i = input_length - 1; i >= 0; i--) {
            reversed_string += input.charAt(i);
        }

        System.out.println(reversed_string);

        scanner.close();


    }
}