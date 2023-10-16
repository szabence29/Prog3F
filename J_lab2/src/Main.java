public class Main {
    public static void main(String[] args) {

        Asztal a = new Asztal();

        a.addJatekos(new Kezdo("Rajmund"));
        a.addJatekos(new Kezdo(("Máté")));
        a.addJatekos(new Robot());
        a.addJatekos(new Mester(13));
        a.addJatekos(new Nyuszi("piros"));
        a.addJatekos(new Ember("Bence"));

        try{
            a.ujJatek();
        } catch (Exception e0){
            System.out.println("Hiba: " + e0);
        }

        try{
            while (a.getKor() != -1)
                a.kor();
        } catch (Exception e1) {
            System.out.println("Hiba: " + e1);
        }

        System.gc();
    }
}