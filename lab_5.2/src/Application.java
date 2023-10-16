import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Fifo fifo = new Fifo();
        ArrayList<Thread> threads = new ArrayList<>(7);

        /*
        Thread producerThread = new Thread(new Producer("demo", fifo, 1000));
        Thread consumerThread = new Thread(new Consumer(fifo, "demo", 2000));

        producerThread.start();
        consumerThread.start();
         */


        for (int i = 0; i < 3; i++ ){
            threads.add(new Thread(new Producer("producer", fifo, 1000)));
        }
        for (int i = 0; i < 4; i++ ){
            threads.add(new Thread(new Consumer(fifo, "consumer", 2000)));
        }
        for(Thread thread : threads){
            thread.start();
        }
    }
}
