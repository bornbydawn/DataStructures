import java.util.*;
//http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
public class BlockingQueueManual{


    private List queue = null;
    private int limit = 0;

    public BlockingQueueManual(List list, int limit){
        this.queue = list;
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) throws InterruptedException{
        while(queue.size() == this.limit){
            wait();
        }
        if(this.queue.size() == 0){
            notifyAll();;
        }

        this.queue.add(item);
    }

    public synchronized Object dequeue() throws InterruptedException{

        if(this.queue.size() == 0){
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }
        return this.queue.remove(0);
    }

    public static void main(String[] args) {
        List a = new LinkedList();
        BlockingQueueManual queue = new BlockingQueueManual(a, 10);

        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);


        Thread pt = new Thread(p);
        Thread ct = new Thread(c);

        //Thread pt2 = new Thread(p);

        pt.start();
        ct.start();
    }



}

class Producer implements Runnable{
    
    protected BlockingQueueManual queue;

    public Producer(BlockingQueueManual queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        
        try{
            // Thread.sleep(500);
            // queue.enqueue(1);
            // Thread.sleep(700);
            // queue.enqueue(2);
            // queue.enqueue(3);
            // Thread.sleep(1500);
            // queue.enqueue(4);

            for(int i =  0 ; i < 12 ; i++){

                queue.enqueue(i);
            }

        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    
    protected BlockingQueueManual queue;

    public Consumer(BlockingQueueManual queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        
        try{
            // System.out.println(queue.dequeue());
            // System.out.println(queue.dequeue());
            // System.out.println(queue.dequeue());

            Thread.sleep(5000);
            for(int i =  0 ; i < 7 ; i++){

                System.out.println(queue.dequeue());
            }
            System.out.println(queue.dequeue());

            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());

            
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}