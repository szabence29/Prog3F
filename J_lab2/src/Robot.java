public class Robot extends Jatekos{
    public static int cnt = 1;
    public int id = 0;

    public Robot(){
        id = cnt++;
    }
    public void lep(){
        System.out.println("Robot neve: " + toString());
        System.out.println("Kor: " + asztal.getKor());
    }

    public String toString(){
        return "Robot" + id;
    }
}
