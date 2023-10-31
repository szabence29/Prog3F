public class Div implements Command {
    public void execute(String[] cmd) {
        if (Main.stack.size() >= 2) {
            int a = Main.stack.pop();
            int b = Main.stack.pop();
            if (a != 0) {
                Main.stack.push(b / a);
            } else {
                System.out.println("Hiba: Nullával való osztás.");
                Main.stack.push(b); // Az eredmény nélkül visszateszi a "b"-t
            }
        } else {
            System.out.println("Hiba: Nem elegendő elem a verem tetején az osztáshoz.");
        }
    }
}
