import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws InterruptedException{
        Fifo f = new Fifo();
        ArrayList<Thread> threads = new ArrayList<>(7);

        for (int i = 0; i < 3; i++ ){
            threads.add(new Thread(new Producer(f, "producer", (int) (Math.random()*1000))));
        }
        for (int i = 0; i < 4; i++ ){
            threads.add(new Thread(new Consumer(f, "consumer", (int) (Math.random()*1000))));
        }
        for(Thread thread : threads){
            thread.start();
        }
    }
}
