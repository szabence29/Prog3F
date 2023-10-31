public class List implements Command{
    @Override
    public void execute(String[] cmd) {
        for (Integer element : Main.stack) {
            System.out.println(element + " ");
        }
    }
}
