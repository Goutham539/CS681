package edu.umb.cs681.hw18;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	
	private Map<java.nio.file.Path, Integer> Hm = new HashMap<java.nio.file.Path, Integer>();
	private ReentrantLock rLock = new ReentrantLock();
	private static ReentrantLock sL = new ReentrantLock();
	private static AccessCounter instance = null;
	private AccessCounter() {};	
	
	public static AccessCounter getInstance() {
		sL.lock();
		try {
			if (instance == null)
				instance = new AccessCounter();
			return instance;
		}
		finally {
			sL.unlock();
		}
	}
	
	public void increment(Path path) {
		rLock.lock();
		try {
			if (Hm.get(path) != null)
				Hm.put(path, Hm.get(path) + 1);
			else 
				Hm.put(path, 1);
		}
		finally {
			rLock.unlock();
		}
	}
	
	public int getCount(Path path) {
		rLock.lock();
		try {
			
			if (Hm.get(path) != null)
				return Hm.get(path);
			else
				return 0;
			
		}
		finally {
			
			rLock.unlock();
		
		}
	}	
}