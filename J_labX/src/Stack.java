import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Stack {
    private Deque<Integer> stack = new ArrayDeque<>();

    public void push(Integer element){
        stack.push(element);
    }

    public Integer pop(){
        return stack.pop();
    }

    public Integer peek(){
        return stack.peek();
    }

    public Iterator<Integer> iterator(){
        return stack.iterator();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

}
