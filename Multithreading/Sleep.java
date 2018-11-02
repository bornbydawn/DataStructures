class SleeperThread implements Runnable{

    @Override
    public void run(){

        for(int i = 0; i < 5; i++){

            System.out.println(Thread.currentThread().getName() + " " + i);

            try{
                Thread.sleep(100);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }

    }


}

public class Sleep{

    public static void main(String[] args) throws InterruptedException{
        SleeperThread st = new SleeperThread();

        Thread t1 = new Thread(st);

        Thread t2 = new Thread(st);

        t1.start(); t2.start();
        t1.join(); t2.join();
    }
}