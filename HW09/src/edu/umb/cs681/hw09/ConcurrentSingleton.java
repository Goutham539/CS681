package edu.umb.cs681.hw09;


import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentSingleton {
	
	private ConcurrentSingleton() {};
	private static AtomicReference<ConcurrentSingleton> instance = new AtomicReference<ConcurrentSingleton>(null);
	
	// Used compareAndSet() method.
	public static AtomicReference<ConcurrentSingleton> getInstance(){
		ConcurrentSingleton singletonInstance = new ConcurrentSingleton();
		if (instance.compareAndSet(null,singletonInstance)) {
            instance.set(singletonInstance);
        }        
        return instance;
    }

	// Main method to check the ConcurrentSingleton.
	 public static void main(String[] args){
	    	for(int i=0; i<10; i++){
	    	new Thread(
	    	()->{System.out.println(ConcurrentSingleton.getInstance());}).start();
	    	}
	    }
}