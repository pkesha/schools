package day05.GarbageCollector;

public class StackDemo {
    static final int MAX = 5;
    int top;
    int[] a = new int[MAX];

    StackDemo() {
        this.top = -1;
    }

    boolean isEmpty() {
        return this.top < 0;
    }

    boolean push(int item){
        if(top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            //Increments to top index since it's adding an element
            a[++top] = item;
            System.out.println(item + " pushed into the stack");
            return true;
        }
    }

    int pop(){
        if(this.top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[this.top--];
        }
    }

    int peek() {
        if(this.top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top];
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for(int i = 0; i < a.length; i++){
            stringBuffer.append(a[i]);
            if(i < a.length - 1) {
                stringBuffer.append(',');
            }
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}

class Main {
    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo();
        stackDemo.push(10);
        stackDemo.push(20);
        stackDemo.push(30);
        stackDemo.push(40);
        stackDemo.push(50);
        stackDemo.push(60);
        System.out.println(stackDemo.peek());
        System.out.println(stackDemo);
    }
}
