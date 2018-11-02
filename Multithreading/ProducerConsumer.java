//https://www.geeksforgeeks.org/inter-thread-communication-java/
import java.util.Scanner;

public class ProducerConsumer{
    public static void main(String[] args) throws InterruptedException{
        
        final PC pc = new PC();

        Thread t1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try{
                    pc.produce();
                }
                catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try{
                    pc.consume();
                }
                catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        //t2.join();
    }


    static class PC{
        void produce() throws InterruptedException{
            synchronized(this){
                System.out.println("Producer thread running");

                //wait infinitely for the thread which has the control on "this" object
                //the object(s) should call notify(notifyAll) to make sure this method can resume execution
                wait();

                System.out.println("Producer resumed");
            }
        }

        void consume() throws InterruptedException{

            //this is here so the processer can transfer the control to the producer
            //basically a way of making sure that the producer gets called first and then relinquishes the control through wait
            //and then the consumer gets called
            Thread.sleep(1000);

            Scanner s = new Scanner(System.in); 
            synchronized(this){

                System.out.println("Waiting for return key");
                s.nextLine();
                System.out.println("Enter pressed");

                //this will make sure that the producer thread gets the control since it is waiting indefinitely
                notify();

               // Thread.sleep(1000);


            }
        }
    }
}