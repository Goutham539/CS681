package edu.umb.cs681.hw05;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable  {
	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}
	
	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		RunnablePrimeGenerator primegen1 = new RunnablePrimeGenerator(1, 250);
		RunnablePrimeGenerator primegen2 = new RunnablePrimeGenerator(251, 500);
		Thread t1 = new Thread(primegen1);
		Thread t2 = new Thread(primegen2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {}

		primegen1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		primegen2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		
		long primeNum = primegen1.getPrimes().size() + primegen2.getPrimes().size();
		System.out.println("\nTotal " + primeNum + " prime numbers found");
        

	}
}