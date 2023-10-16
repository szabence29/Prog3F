import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();

            if (command.equals("exit")){
                System.exit(0);
            }
        }
    }
}