public class Sum{
    public static void main(String[] args) throws InterruptedException{
        
        final int sumTo = Integer.MAX_VALUE;

        long halfSums[] = new long[2];

        Thread single = new Thread(new Runnable(){
        
            @Override
            public void run() {
                long sum = 0;
                for(int i = 0; i < sumTo; i++)
                sum = sum + 1;

                System.out.println("Sum by single thread = " + sum);
            }

        });

        long start = System.currentTimeMillis();
        single.start();
        single.join();
        System.out.println("Execution time for single thread: " + (System.currentTimeMillis() - start));

        Thread t1 = new Thread(new Runnable(){
        
            
            @Override
            public void run() {
                

                long sum = 0;

                for(int i = 0; i < sumTo/2 ; i++)
                sum = sum + 1;

                halfSums[0] = sum;
            }

        });

        Thread t2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                final int sumTo = Integer.MAX_VALUE;

                long sum = 0;

                for(int i = sumTo/2; i < sumTo ; i++)
                sum = sum + 1;

                halfSums[1] = sum;
            }
        });

        start = System.currentTimeMillis();
        t1.start();
        t2.start();

        
        
        t1.join();
        System.out.println("State of t1 after t1 is joined is: " + t1.getState());

        System.out.println("State of t2 when t1 is joined is: " + t2.getState());
        t2.join(); 
        //t2.notify();

        

        System.out.println("Execution time for two thread: " + (System.currentTimeMillis() - start));

        System.out.println("Combined sum of both the threads = " + (halfSums[0] + halfSums[1]));
    }
}