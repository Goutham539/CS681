package edu.umb.cs681.hw01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

	private String model, make;
	private int mileage, year, dominationCount;
	private float price;

	public Car(String make, String model, int mileage, int year, float price) {
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

	public int getDominationCount() {
		return this.dominationCount;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setDominationCount(ArrayList<Car> cars) {
		int count = 0;
		for (Car car : cars) {
			if (!car.equals(this)) {
				float price = car.getPrice();
				int year = car.getYear();
				int mileage = car.getMileage();

				if (this.getYear() >= year && this.getMileage() <= mileage && this.getPrice() <= price) {
					if (this.getYear() > year || this.getMileage() < mileage || this.getPrice() < price) {
						count++;
					}
				}
			}
		}
		this.dominationCount = count;
	}
	
	public static void sortByPriceCars(ArrayList<Car> cars) {
		List<Car> sortByPrice = cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());
		System.out.println("Sorting the order in increasing order sorted by price");
		sortByPrice.forEach((Car car) -> System.out
				.println(car.getMake() + " " + car.model + " " + car.mileage + " " + car.year + " " + car.getPrice()));
	}
	
	public static void sortByYearCars(ArrayList<Car> cars) {
		List<Car> sortByYear = cars.stream().sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());
		System.out.println("\n");
		System.out.println("Sorting the order in increasing order sorted by Year");
		sortByYear.forEach((Car car) -> System.out
				.println(car.getMake() + " " + car.model + " " + car.mileage + " " + car.year + " " + car.getPrice()));
	}
	
	public static void sortByMileageCars(ArrayList<Car> cars) {
		List<Car> sortByMileage = cars.stream().sorted(Comparator.comparing(Car::getMileage))
				.collect(Collectors.toList());
		System.out.println("\n");
		System.out.println("Sorting the order in increasing order sorted by Mileage");
		sortByMileage.forEach((Car car) -> System.out
				.println(car.getMake() + " " + car.model + " " + car.mileage + " " + car.year + " " + car.getPrice()));
		
	}

	public static void sortByDominationCars(ArrayList<Car> cars) {
		List<Car> sortByDominationCount = cars.stream().sorted(Comparator.comparing(Car::getDominationCount))
				.collect(Collectors.toList());
		System.out.println("\n");
		System.out.println("Sorting the order in increasing order sorted by Domination Count");
		sortByDominationCount.forEach((Car car) -> System.out.println(car.getMake() + " " + car.model + " "
				+ car.mileage + " " + car.year + " " + car.getPrice() + " " + car.getDominationCount()));
		
	}
	
	public static void addCars(ArrayList<Car> cars) {
		cars.add(new Car("Ford", "Figo", 24, 2013, 40000));
		cars.add(new Car("Maruti", "800", 16, 2002, 5000));
		cars.add(new Car("Mahindra", "XUV", 18, 2019, 65000));
		cars.add(new Car("Acura", "avinci", 28, 2016, 50000));

	}
	
	public static void main(String args[]) {
		ArrayList<Car> cars = new ArrayList<>();
		addCars(cars);
		cars.forEach((Car car) -> car.setDominationCount(cars));
		sortByPriceCars(cars);
		sortByYearCars(cars);
		sortByMileageCars(cars);
		sortByDominationCars(cars);
	}

}