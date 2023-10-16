public class Nyuszi extends Jatekos {
    public String szin;

    public Nyuszi(String sz){
        szin = sz;
    }

    public void lep(){
        System.out.println("Nyuszi színe: " + toString());
        System.out.println("Kör: " + asztal.getKor());

        if(asztal.getTet() < 50){
            asztal.emel(5);
        } else {
            System.out.println("Húha!");
        }
    }

    public String toString(){
        return szin;
    }
}
