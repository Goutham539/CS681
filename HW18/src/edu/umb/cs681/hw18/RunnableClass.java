package edu.umb.cs681.hw18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableClass implements Runnable{

	 public void run() {
	    	
	    }

	    public static void main(String[] args) {
	    	
	    	ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();
	        WithdrawRunnable withdraw = new WithdrawRunnable(account);
	        DepositRunnable deposit = new DepositRunnable(account);

	        ExecutorService executor = Executors.newFixedThreadPool(3);
	        executor.execute(withdraw);
	        executor.execute(deposit);
	        deposit.setDone();
	        withdraw.setDone();
	        executor.shutdown();


	    }
}