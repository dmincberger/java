import java.util.Scanner;

class Random_int {

    protected int randomize(){

        double test = Math.random() * 340515;
        double random_double = Math.floor(test);

        return (int)random_double;

    }

}

class Game {

    static Scanner sc = new Scanner(System.in);

    public int getGuess() {
        System.out.println("Guess the number!: ");
        return sc.nextInt();
    }

    public boolean checkGuess(int random_number, int guess) {
        if (random_number == guess) {
            return true;
        } else {
            if (random_number < guess) {
                System.out.println("The random number is lower than the guess! ");
            }
            if (random_number > guess) {
                System.out.println("The random number is higher than the guess! ");
            }
            return false;
        }
    }

}

    public class Main {

         static Random_int randomInt = new Random_int();
         static Game game = new Game();

         static int random_number = randomInt.randomize();

        public static void main(String[] args){

        while (true){

            int guess = game.getGuess();
            boolean score = game.checkGuess(random_number, guess);

            if (score){
                System.out.println("Your score is correct!");
                break;

            } else {
                System.out.println("Your score is incorrect!");
            }

        }
    }
}