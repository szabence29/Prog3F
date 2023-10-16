import java.util.ArrayList;
public class Fifo {
    private ArrayList<String> buffer;
    {
        buffer = new ArrayList<>(10);
    }

    public synchronized void put(String item) throws InterruptedException{
        while (buffer.size() >= 10){
            System.out.println("put(), Thread ID: " +Thread.currentThread().getId());
            wait();
        }
        buffer.add(item);
        System.out.println("put(), Thread ID: " +Thread.currentThread().getId());
        notifyAll();
    }

    public synchronized String get() throws InterruptedException{
        while (buffer.isEmpty()){
            System.out.println("get(), Thread ID: " +Thread.currentThread().getId());
            wait();
        }
        String item = buffer.remove(0);
        System.out.println("get(), Thread ID: " +Thread.currentThread().getId());
        notifyAll();
        return item;
    }
}
