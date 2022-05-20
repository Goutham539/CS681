package edu.umb.cs681.hw13;

public class RunnableClass implements Runnable{

	 public void run() {
	    	
	    }

	    public static void main(String[] args) {
	    	
	    	ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();
	        WithdrawRunnable withdraw = new WithdrawRunnable(account);
	        DepositRunnable deposit = new DepositRunnable(account);

	        Thread t1 = new Thread(deposit);
	        Thread t2 = new Thread(withdraw);
	        Thread t3 = new Thread(deposit);
	        Thread t4 = new Thread(withdraw);
	        Thread t5 = new Thread(deposit);
	        Thread t6 = new Thread(withdraw);
	        Thread t7 = new Thread(deposit);
	        Thread t8 = new Thread(withdraw);
	        Thread t9 = new Thread(deposit);
	        Thread t10 = new Thread(withdraw);
	        Thread t11 = new Thread(deposit);
	        Thread t12 = new Thread(withdraw);
	        Thread t13 = new Thread(deposit);
	        Thread t14 = new Thread(withdraw);
	        Thread t15 = new Thread(deposit);

	        t1.start();
	        t2.start();
	        t3.start();
	        t4.start();
	        t5.start();
	        t6.start();
	        t7.start();
	        t8.start();
	        t9.start();
	        t10.start();
	        t11.start();
	        t12.start();
	        t13.start();
	        t14.start();
	        t15.start();

	        deposit.setDone();
	        withdraw.setDone();

	        t1.interrupt();
	        t2.interrupt();
	        t3.interrupt();
	        t4.interrupt();
	        t5.interrupt();
	        t6.interrupt();
	        t7.interrupt();
	        t8.interrupt();
	        t9.interrupt();
	        t10.interrupt();
	        t11.interrupt();
	        t12.interrupt();
	        t13.interrupt();
	        t14.interrupt();
	        t15.interrupt();

	        try {
	            t1.join();
	            t3.join();
	            t5.join();
	            t7.join();
	            t9.join();
	            t11.join();
	            t13.join();
	            t15.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }


	    }
}