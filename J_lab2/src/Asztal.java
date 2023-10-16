import java.util.Random;

public class Asztal {
    private Jatekos[] jatekosok;
    private double tet;
    private int kor;
    private double goal;


    public Asztal() {
        jatekosok = new Jatekos[10];
    }
    public void ujJatek(){
        kor = 0;
        setGoal();
        System.out.println(goal);
    }

    public void addJatekos(Jatekos j){
        for (int i = 0; i < 11; i++){
            if (jatekosok[i] == null){
                if(i == 10) {
                    throw new RuntimeException();
                } else {
                    jatekosok[i] = j;
                    j.setAsztal(this);
                    /*
                    for (int k = 0; k<10; k++){
                        System.out.println(jatekosok[k]);
                    }

                     */
                    return;
                }
            }
        }

    }

    public int getKor(){
        return kor;
    }

    public void emel(double d){
        tet = tet + d;
    }

    public void kor() throws NincsJatekos{

        if(jatekosok[0] == null){
            throw new NincsJatekos("Az asztal üres.");
        }

        if(kor == -1){
            System.out.println("Vége a játéknak.");
            return;
        }

        int count = 0;

        while (jatekosok[count] != null){
            jatekosok[count].lep();

            if(tet >= (goal*1.1)){
                System.out.println("Senki sem nyert.");
                ujJatek();
            } else {
                if (tet >= goal){
                    System.out.println("A gyoztes jatekos: " + jatekosok[count]);
                    ujJatek();
                    kor = -1;
                    return;
                }
            }
            System.out.println("Aktuális tét: " + tet);
            count++;
            kor++;
        }
    }

    public double getTet(){
        return tet;
    }

    public void setGoal(){
        Random r = new Random();
        goal = r.nextDouble(0, 100);
    }
}
