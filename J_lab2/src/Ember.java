import java.util.Scanner;
public class Ember extends Jatekos{
    public String nev;

    public Ember(String n){
        nev = n;
    }

    public void lep(){
        System.out.println("Ember neve: " + toString());
        System.out.println("Kör: " + asztal.getKor());

        if(asztal.getKor() != -1) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Mennyivel emeljen?");
            double stet = scanner.nextDouble();

            asztal.emel(stet);
        }
    }

    public String toString() {return nev;}
}
