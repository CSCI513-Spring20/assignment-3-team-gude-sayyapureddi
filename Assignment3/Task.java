
public class Task implements Runnable {
 
    private int num;
	
	public Task(int num) {
		this.num = num;   //Initializing total number count to variable num
	}
	
	@Override 
	public void run() {
	    	System.out.println("\n"+Thread.currentThread().getName()+" Start");  //Assigning a Thread
	        processCommand();
	    	try {
		    checkPrime();								// Assigning the task to this particular thread
		} catch (InterruptedException e) {				// Printing exception error
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	        System.out.println("\n"+Thread.currentThread().getName()+" End\n");  // Thread ends
		
		
	}
	
	private void processCommand() {   // Delaying the current running thread
	        try {
	            Thread.currentThread();
				Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	
	public void checkPrime() throws InterruptedException{  // prime number check function

	        for(int i = 2;  i <= num/2; i ++)
	     		{
	     			try {
	     				Thread.sleep(100);
	     			}
	     			catch(Exception ex) {
	     				
	     			}
	     			if ( num % i == 0)
	     			{
	     				System.out.printf("\n%d  is not prime : "+Thread.currentThread().getName()+"\n", num);
	     				return; 
	     				// Printing the task outcome along with current thread 
	     			}
	     		}
	     		
	     		System.out.printf("\n%d  is prime: "+Thread.currentThread().getName()+"\n", num);
	     		Thread.currentThread();
				Thread.sleep(5000);
	 
	}
}