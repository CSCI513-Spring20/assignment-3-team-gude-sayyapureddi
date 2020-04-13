
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

 
public class ThreadPool {
	boolean se=false;
    private final BlockingQueue<Runnable>Queue; // Creating a linked list
    private final Thread[] workerThreads;    // Creating an array of threads

    public ThreadPool(int numThreads) {
       Queue = new LinkedBlockingQueue<>();
        workerThreads = new Thread[numThreads];
        int i = 0;
        for (Thread t : workerThreads) {     // Creating threads
            t = new Worker("Custom Pool Thread " + ++i);
            t.start();
        }
    }

    public void addTask(Runnable r) {   // Adding tasks to threads
        try {
           Queue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  public void shutdown() {   // Shutdown method to exit program after all tasks completed
	  this.se = true;
  }
    class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        public void run() {   // Shutting down if no exception error
            while (true) {
            	 if (se) {
            		 System.out.println("Tasks completed : Shutting down thread pool");
            		 System.exit(0);
					  break;
				  }
                try {
                   Queue.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
