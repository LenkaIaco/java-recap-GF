package unitTesting.cowsAndBulls;

import java.util.Scanner;

public class UserFacingMain {
    public static void main(String[] args) {
        CAB newGame = new CAB();
        Scanner scanner = new Scanner(System.in);
        newGame.run(scanner);
    }
}
