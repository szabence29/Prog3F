import java.util.Random;
public class Jatekos {
    protected Asztal asztal;

    public void lep(){
        System.out.println(asztal.getTet());
        System.out.println(asztal.getKor());
    }

    public void setAsztal(Asztal a){
        asztal = a;
    }
}
