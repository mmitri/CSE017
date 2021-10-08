public class StackObject {
    private Object[] elements;
    private int size;

    public StackObject(){
        elements = new Object[10];
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public String toString(){
        String s = "Stack: [";
        for(int i=0;i<size;i++){
            s = s + elements[i] + ", ";
        }
        s = s + "]";
        return s;
    }
    public void push(Object item){
        elements[size++] = item;
    }
    public Object peek(){
        return elements[size-1];
    }
    public Object pop(){
        return elements[--size];
    }
}
