package edu.umb.cs681.hw10;

public class MultiThread implements Runnable {

    public void run() {
    	
    	Aircraft objAircraft = new Aircraft(new Position(65.4,-41.23,29));
        System.out.println("The original position of aircraft is \t\t:"+ objAircraft.getPosition()+"\n");
        objAircraft.setPosition(objAircraft.getPosition().changeAlt(15));
        System.out.println("Aircraft's original position changed to	\t:"+ objAircraft.getPosition()+"\n");
        objAircraft.setPosition(new Position(63.7, -78.04, 21));
        System.out.println("New position of aircraft is set to	\t:"+ objAircraft.getPosition()+"\n");
    }

    public static void main(String[] args) {
    	
    	Thread T1 = new Thread(new MultiThread());
		Thread T2 = new Thread(new MultiThread());
		
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