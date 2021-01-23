package StackAndQueue;

class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(5);
        //equeue 2 4 6 8 10 at the end
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(10);
        //dequeue 2 elements from the start
        queue.dequeue();
        queue.dequeue();
        //enqueue 12 and 14 at the end
        queue.enqueue(12);
        queue.enqueue(14);

        System.out.println("Queue:");
        while(!queue.isEmpty()){
            System.out.print(queue.dequeue()+" ");
        }
    }
}