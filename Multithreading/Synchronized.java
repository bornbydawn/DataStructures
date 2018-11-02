class Worker {

    public void sendMessage(char[] string) {

        for(int i = 0; i < string.length ; i++){

            System.err.println(string[i]);

            // try{
            //     Thread.sleep(50);
            // }
            // catch(InterruptedException ie){
            //     ie.printStackTrace();
            // }
        }
       
    }
}

class ThreadSend implements Runnable {

    Worker w;
    private char[] message;

    public ThreadSend(Worker worker, char[] msg) {
        w = worker;
        message = msg;
    }

    @Override
    public void run() {

        //synchronized (w) {
            w.sendMessage(message);
        //}
    }

}

public class Synchronized {

    public static void main(String[] args) {
        Worker w = new Worker();

        Thread a = new Thread(new ThreadSend(w, "Hey".toCharArray()));
        Thread b = new Thread(new ThreadSend(w, "Bye".toCharArray()));

        a.start();
        b.start();

    }
}