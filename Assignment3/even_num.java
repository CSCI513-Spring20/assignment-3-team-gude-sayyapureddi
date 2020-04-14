import java.util.ArrayList;

public class even_num extends Thread {
	even_num(String name) {
		// Pass name to Thread name.
		super(name);
	}

	ArrayList<Integer> even() // Defining an array with integers type
	{
		int n = 100;
		ArrayList<Integer> j = new ArrayList<Integer>(); // Initializing a new array
		System.out.print("Even Numbers from 1 to " + n + " are: "); // Calculation of even numbers from a given set
		for (int i = 1; i <= n; i++) {
			// if number%2 == 0 it means its an even number
			if (i % 2 == 0) {
				j.add(i);
			}
		}
		return j; // Returning the array

	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " start :" + getName()); // Thread assign
		System.out.println(even() + "\n"); // Print the current task
		System.out.println(Thread.currentThread().getName() + " end  :" + getName()); // Thread ends
	}

}
