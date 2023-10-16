import java.io.IOException;

public class Producer implements Runnable {
    private String string;
    private Fifo fifo;
    private int sleeptime;
    private int iteration = 0;

    public Producer(Fifo f, String s, int t){
        string = s;
        fifo = f;
        sleeptime = t;
    }

    public void go() throws InterruptedException{
        while (true){
            iteration++;
            fifo.put(string + " " + iteration);
            String time = String.valueOf(System.currentTimeMillis());
            System.out.println(string + " produced " + iteration + " " + time.substring(time.length()-5));
            Thread.sleep(sleeptime);
        }
    }

    @Override
    public void run(){
        try{
            this.go();
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
