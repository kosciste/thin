public class StackElement {
    private static int COUNTER  = 0;
    private int id;
    private int value;

    public StackElement(int value){
        id = COUNTER;
        this.value = value;
        COUNTER++;

    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StackElement{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
