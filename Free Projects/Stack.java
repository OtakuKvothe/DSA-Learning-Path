public class Stack {

    private Integer[] stack;
    private int pointer;
    private final int MAX_SIZE;

    public Stack(int size){
        stack = new Integer[size];
        pointer = -1;
        MAX_SIZE = size;
    }

    public void push(int num){
        if(pointer == MAX_SIZE - 1){
            System.out.println("Stack is full");
            throw new IllegalArgumentException();
        }
        stack[++pointer] = num;
    }

    public Integer pop(){
        if(pointer < 0){
            System.out.println("Stack is empty");
            throw new NullPointerException();
        }
        return stack[pointer--];
    }

    public static void main(String[] args) {
        //Stack stk = new Stack();
    }
}
