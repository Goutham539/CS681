package edu.umb.cs681.hw02;

import java.util.ArrayList;

public class Car {

	private String model, make;
	private int mileage, year;
	private int price;

	public Car(String make, String model, int mileage, int year, int price) {
		super();
		this.model = model;
		this.make = make;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static void addNewCars(ArrayList<Car> cars) {
		cars.add(new Car("Ford", "Figo", 24, 2013, 40000));
		cars.add(new Car("Maruti", "800", 16, 2002, 5000));
		cars.add(new Car("Mahindra", "XUV", 18, 2019, 65000));
		cars.add(new Car("Acura", "avinci", 28, 2016, 50000));

	}

	static Integer getMinPrice(ArrayList<Car> listOfCars) {
		return listOfCars.stream().map((Car car) ->car.getPrice() )
        .reduce(1000000000, (res, price)->price>res ? res : price);
		
	}

	static Integer getMaxPrice(ArrayList<Car> listOfCars) {
		return listOfCars.stream().map((Car car) ->car.getPrice() )
                .reduce(0, (res,price)->res > price ? res : price);
	}
	
	static Integer getAvgPrice(ArrayList<Car> listOfCars) {
		return listOfCars.stream().map((Car car) ->car.getPrice() )
                .reduce(0, (res,price) -> res+price, (finalRes, intermediateResult) -> finalRes)/listOfCars.size();
	}
	
	public static void main(String args[]) {
		ArrayList<Car> cars = new ArrayList<>();
		addNewCars(cars);
		Integer minPrice = getMinPrice(cars);
		System.out.println("Car with Minimim price has a value of: " + minPrice);
		Integer maxPrice = getMaxPrice(cars);
		System.out.println("Car with maximum price has a value of : " + maxPrice);
		Integer avgPrice = getAvgPrice(cars);
		System.out.println("Average Price of car: " + avgPrice);
		
	}
}