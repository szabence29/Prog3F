public class Pop implements Command{
    @Override
    public void execute(String[] cmd) {
        if(!Main.stack.isEmpty()){
            Main.stack.pop();
        }
    }
}
