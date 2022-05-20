package edu.umb.cs681.hw10;

import java.util.concurrent.atomic.AtomicReference;

//Used atomicReferenceType - skipped thread synch
public class Aircraft {
	private AtomicReference<Position> position; // Shared (non-final) variable
	public Aircraft(Position pos){ 
		position = new AtomicReference<>(pos); 
	}
	public void setPosition(Position pos){
		position.set(pos);;
	}
	public Position getPosition(){ // 2 steps; NOT thread-safe.
		return this.position.get();
	} 
}