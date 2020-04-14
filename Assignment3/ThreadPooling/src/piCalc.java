class piCalc extends Thread {
	piCalc(String name) {
		// Pass name to Thread name.
		super(name);
	}

	double calcPI() // Calculation of Pi Value
	{
		boolean negative = true;
		double pi = 0.0;
		for (int i = 3; i < 100000; i += 2) {
			if (negative)
				pi -= (1.0 / i);
			else
				pi += (1.0 / i);
			negative = !negative;
		}
		pi += 1.0;
		pi *= 4.0;
		return pi;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " start: " + getName()); // Thread assigning
		for (int i = 0; i < 5; i++) // Printing Pi values
			System.out.println("PI Value" + ": " + calcPI());

		System.out.println("\n" + Thread.currentThread().getName() + " End: " + getName());
	}
}