package edu.umb.cs681.hw07;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton{
	private ConcurrentSingleton() {};

	private static ConcurrentSingleton COncSing = null;
	private static ReentrantLock lock = new ReentrantLock();

	public static ConcurrentSingleton getInstance() {
		lock.lock();
		try {
			if (COncSing == null) {
				COncSing = new ConcurrentSingleton();
			}
			return COncSing;
		} finally {
			lock.unlock();
		}
	}
	public static void main(String[] args){
		
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(() -> {
				System.out.println(ConcurrentSingleton.getInstance());
			});
			t.start();
		}	
	}
}