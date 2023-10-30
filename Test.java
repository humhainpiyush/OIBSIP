public class Test {

    private static int points = 0;
    private static int rounds = 0;
    private static int numChances = 0;

    private static void displayScore(){
        System.out.println("\n=====GAME OVER=====");
        System.out.println("Score Points: " + (points * 5));
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Total attempts taken: " + numChances);
    }
    public static void main(String[] args) {
        displayScore();
    }
}
