import UserInterface.Window;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int input;
        Scanner scanner = new Scanner(System.in);
        Window window = Window.getInstance(800, 600);

        while (true) {
            System.out.println("Load simulation state:");
            try {
                input = scanner.nextInt();
                window.refresh(input);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Illegal index");
            } catch (InputMismatchException e) {
                System.out.println("Illegal type of data");
                scanner.nextLine();
            }
        }
    }
}