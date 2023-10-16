import java.util.Random;
class Consumer implements Runnable {
    private Fifo fifo;
    private String s;
    private int sleepTime;

    public Consumer(Fifo fifo, String s, int sleepTime) {
        this.fifo = fifo;
        this.s = s;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            try {
                String item = fifo.get();
                long currentTimeMillis = System.currentTimeMillis();
                String formattedTime = String.format("%05d", currentTimeMillis % 100000);
                System.out.println("consumed " + s + " " + item + " " + formattedTime);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}