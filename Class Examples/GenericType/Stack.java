import java.util.ArrayList;

public class Stack<E>{
    private ArrayList<E> elements;

    public Stack(){
        elements = new ArrayList<>();
    }
    public int size(){
        return elements.size();
    }
    public boolean isEmpty(){
        return elements.isEmpty();
    }
    public String toString(){
        return "Stack: " + elements.toString();
    }
    public void push(E item){
        elements.add(item);
    }
    public E peek(){
        return elements.get(size()-1);
    }
    public E pop(){
        E item = elements.get(size()-1);
        elements.remove(size()-1);
        return item;
    }
}