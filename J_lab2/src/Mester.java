public class Mester extends Jatekos {
    int level = 0;

    public Mester(int l){
        level = l;
    }

    public void lep(){
        System.out.println("Mester fokozata: " + toString());
        System.out.println("Kor: " + asztal.getKor());

        double pot = asztal.getTet() / 100;

        asztal.emel(pot*level);
    }

    public String toString(){
        return "Mester" + level;
    }
}
