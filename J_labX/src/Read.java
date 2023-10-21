import java.util.Scanner;
public class Read implements Command {
    @Override
    public void execute(String[] cmd) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            Main.stack.push(value);
        }
    }
}