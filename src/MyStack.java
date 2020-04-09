import java.lang.reflect.Array;
import java.util.*;

public class MyStack<T>{
    private static final int INITIAL_SIZE = 10;
    private int pointer;
    private T[] elements;

    public MyStack(Class<T> t){
        pointer = 0;
        @SuppressWarnings("unchecked")
        final T[] elements = (T[]) Array.newInstance(t, INITIAL_SIZE);
        this.elements = elements;
    }

    /**
     * Pushes one elment at the top of the stack
     * @param element
     */
    public void push(T element){
        if (pointer == elements.length) {
            expandSize();
        }
        elements[pointer] = element;
        pointer++;
    }

    /**
     * Returns the length of the stack
     * @return
     */
    public int length(){
        return pointer;
    }

    /**
     * Return the elment at the top of the stack
     * @return
     */
    public T peek(){
        if(empty()){
            return null;
        }
        else {
            return elements[pointer-1];
        }
    }

    /**
     * Returns true it the stack is empty
     * @return
     */
    public boolean empty(){
        return pointer == 0;
    }

    /**
     * Pops the first top elment of the stack
     * @return
     */
    public T pop(){
        pointer--;
        T element = elements[pointer];
        elements[pointer] = null;
        return element;
    }

    /**
     * Prints the stack reversed to get a visual component
     */
    public void printStack(){
        for(int i = pointer - 1; i >= 0; i--){
            System.out.println("| " +  elements[i].toString() + " |");
            System.out.println(" ___ ");
        }
    }

    /**
     * Expands the size of the stack if needed
     */
    private void expandSize() {
        int increasedSize = elements.length * 2;
        // create a new array with double size and copy existing contents into it
        elements = Arrays.copyOf(elements, increasedSize);
    }
}