package edu.umb.cs681.hw18;

import java.nio.file.FileSystems;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.nio.file.Path;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {
	
	private ReentrantLock rLock = new ReentrantLock();
	private boolean done = false;
	
	public void setDone() {
		rLock.lock();
		try {
			done = true;
		}
		finally {
			rLock.unlock();
		}
	}

	public void run() {
		
		String[] files = {"a.html", 
						  "b.html",
						  "c.html",
						  "d.html",
						  "e.html"};
		AccessCounter ac = AccessCounter.getInstance();
		
		while (true) {			
			rLock.lock();
			try {
				if(done) {
	    			System.out.println("Threads execution completed");
	    			break;
	    		}
				
				int num = new Random().nextInt(files.length);
				Path path = FileSystems.getDefault().getPath(".", files[num]);				
				
				ac.increment(path);
				System.out.println(files[num] + " path count: " + ac.getCount(path));
			}
			finally {
				rLock.unlock();
			}
			
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println("Induced Error in: "+Thread.currentThread().getName()+e.toString());
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
	
		RequestHandler Rh = new RequestHandler();
        ExecutorService executor = Executors.newFixedThreadPool(15);
        executor.execute(Rh);
        executor.shutdown();
		
	}	
}