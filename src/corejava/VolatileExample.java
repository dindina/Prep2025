package corejava;

public class VolatileExample {

    // A shared variable that will be accessed by multiple threads
    // if  this running is not volatile , then this program keeps on running
    private volatile boolean running = true;

    public void start() {
        // Thread 1: Modifies the 'running' variable
        new Thread(() -> {
            int count = 0;
            while (running) {
                System.out.println("incrementing " + count);
                count++;
            }
            System.out.println("Thread 1 stopped. Count: " + count);
        }).start();

        // Thread 2: Changes the 'running' variable to false after a delay
        new Thread(() -> {
            try {
                Thread.sleep(5000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 setting running to false");
            running = false;
        }).start();
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        example.start();
    }
}