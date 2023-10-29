import java.util.EmptyStackException;
import java.util.LinkedList;
public class Stack<T>{
    private LinkedList<T> list;
    private int max;

    public Stack(int m){
        list = new LinkedList<T>();
        max = m;
    }

    public void push(T t){
        if (list.size() >= max){
            list.remove(0);
        }
        list.add(0, t);
    }

    public T pop() throws EmptyStackException{
        if(list.size() == 0){
            throw new EmptyStackException();
        }
        return list.remove(max-1);
    }
}
