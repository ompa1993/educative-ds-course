package StackAndQueue;

public class Queue<V> {
    private int maxSize;
    private int front;
    private int back;
    private int currentSize;
    private V[] array; //The actual Queue used for storing items.


    public Queue(int max_size){
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize == maxSize;
    }

    public V top(){
        return array[front];
    }

    public void enqueue(V value){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }
        back = (back + 1) % maxSize;
        array[back] = value;
        currentSize++;
    }

    public V dequeue() {
        V result = null;
        if (!isEmpty()) {
            V data = array[front];
            front = (front + 1) % maxSize;
            currentSize--;
            result = data;
        }
        return result;
    }
}
