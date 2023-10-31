public class Dup implements Command {
    @Override
    public void execute(String[] cmd) {
        if (!Main.stack.isEmpty()) {
            int top = Main.stack.peek();
            Main.stack.push(top);
        }
    }
}