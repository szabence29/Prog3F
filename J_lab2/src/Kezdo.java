public class Kezdo extends Jatekos {
    public String nev;

    public Kezdo(String n){
        nev = n;
    }
    public void lep(){
        System.out.println("Játékos neve: " + toString());
        System.out.println("Kör: " + asztal.getKor());

        if(asztal.getKor() % 2 == 0){
            asztal.emel(1);
        } else {
            asztal.emel(0);
        }
    }

    public String toString(){
        return nev;
    }
}