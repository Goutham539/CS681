package edu.umb.cs681.hw10;

public class RunnableClass implements Runnable {

    public void run() {
    	
    	//Defining the position of aircraft
    	Aircraft suprCrft = new Aircraft(new Position(65.4,-41.23,29));
        System.out.println("The original position of aircraft is \t\t:"+ suprCrft.getPosition()+"\n");
        //Changing the latitude value to 15
        suprCrft.setPosition(suprCrft.getPosition().changeLat(15));
        System.out.println("Aircraft's original position changed to	\t:"+ suprCrft.getPosition()+"\n");
        //Setting the new position to (63.7, -78.04, 21) 
        suprCrft.setPosition(new Position(63.7, -78.04, 21));
        System.out.println("New position of aircraft is	\t:"+ suprCrft.getPosition()+"\n");
        System.out.println("Distance from previous coordinate is \t:"+ suprCrft.getPosition().distanceTo(new Position(65.4,-41.23,29))+"\n");
    }

    public static void main(String[] args) {
    	
    	Thread T1 = new Thread(new RunnableClass());
		Thread T2 = new Thread(new RunnableClass());
		
		T1.start();
		T2.start();
		
		try {
			T1.join();
			T2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}        
    }
}