import java.util.Random;

class Producer implements Runnable {
    private String text;
    private Fifo fifo;
    private int sleepTime;

    public Producer(String text, Fifo fifo, int sleepTime) {
        this.fifo = fifo;
        this.text = text;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int count = 0;
        while (true) {
            try {
                String message = text + " " + count;
                fifo.put(message);
                long currentTimeMillis = System.currentTimeMillis();
                String formattedTime = String.format("%05d", currentTimeMillis % 100000);
                System.out.println("produced " + message + " " + formattedTime);
                count++;
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
