public class Sub implements Command{
    public void execute(String[] cmd) {
        if (Main.stack.size() >= 2) {
            int a = Main.stack.pop();
            int b = Main.stack.pop();
            Main.stack.push(b - a);
        } else {
            System.out.println("Hiba: Nem elegendő elem a verem tetején a kivonáshoz.");
        }
    }
}
