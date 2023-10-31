public class Push implements Command{
    @Override
    public void execute(String[] cmd) {
        if(cmd.length > 1) {
            int value = Integer.parseInt(cmd[1]);
            Main.stack.push(value);
        }
    }
}
