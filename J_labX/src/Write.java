public class Write implements Command {
    @Override
    public void execute(String[] cmd) {
        if (!Main.stack.isEmpty()) {
            int top = Main.stack.pop();
            System.out.println(top);
        }
    }
}
