class MainThread extends Thread{
    public static void main(String[] args) {
        Thread current = Thread.currentThread();

        ChildThread ct = new ChildThread();
        //ct.run();

        System.out.println(current.getName() + "priority: " + current.getPriority());
        System.out.println(ct.getName() + "priority: " + ct.getPriority());

    }
}

class ChildThread extends Thread{

    @Override
    public void run() {
        System.out.println("In child thread");
        super.run();
    }
}