
public class Scheduler implements Runnable {

	static Task task;// task2
	static int size;
	static piCalc task1;// task1
	static even_num task3;// task3

	public Scheduler(int size) { // Initializing the tasks
		task1 = new piCalc("Task1");
		task3 = new even_num("Task3");
		Scheduler.size = size; // Assigning value to size
	}

	@Override // scheduler class runnable
	public void run() {
		// TODO Auto-generated method stub
		ThreadPool pool = new ThreadPool(size); // New Threadpool named pool is created
		pool.addTask(task1); // Task1 is assigned to pool
		for (int i = 1; i < 12; i++) { // Working of task2
			Task task = new Task(i);// input to verify prime number
			pool.addTask(task);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pool.addTask(task3); // Task3 is assigned to pool

		try {
			Thread.sleep(5000); // Delaying the current thread
			pool.shutdown(); // Shutting down the entire program after tasks completed
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
