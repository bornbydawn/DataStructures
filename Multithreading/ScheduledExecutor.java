import java.util.concurrent.*;

public class ScheduledExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException{

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Callable() {
            public Object call() throws Exception {
                System.out.println("Executed!");
                return "Called!";
            }
        }, 5, TimeUnit.SECONDS);

        //System.out.println("result = " + scheduledFuture.get());

        System.out.println("Hello World");

        scheduledExecutorService.shutdown();
    }
}
