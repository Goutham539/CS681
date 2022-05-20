package edu.umb.cs681.hw16;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String make, model;
    private int mileage, year,price, dominationCount;

    public Car(String make, String model,int mileage, int year, int price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public int getDominationCount() {
        return dominationCount;
    }
    public String getmake() {
        return make;
    }
    public String getmodel() {
        return model;
    }

    public int getYear() {
        return year;
    }
    public int getPrice() {
        return price;
    }
    public int getMileage() {
        return mileage;
    }

    public void setDominationCount(List<Car> cars) {
        for (Car car : cars) {
            if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
                    && (car.getYear() <= this.getYear())) {
                this.dominationCount++;
            }
        }
        this.dominationCount--;
    }

    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        if(make.equals(car.getmake()) && model.equals(car.getmodel()) && year==car.getYear() && mileage==car.getMileage() && price==car.getPrice() && dominationCount==car.getDominationCount())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return this.make+" - "+this.model+" - "+this.year+" - Mileage:"+this.mileage+" - $"+this.price;
    }

    public static void main(String[] args) {
    	List<Car> Car = new ArrayList<>();
    	Car.add(new Car("Ford", "Figo", 2013, 24, 40000));
    	Car.add(new Car("Maruti", "800", 2002, 16, 5000));
    	Car.add(new Car("Mahindra", "XUV", 2019, 18, 65000));
    	Car.add(new Car("Acura", "avinci", 2016, 28, 50000));
    	Car.forEach((Car car) -> car.setDominationCount(Car));

       
        
        int maxMileage = Car.stream().parallel().map((Car car) -> car.getMileage())
				 .reduce(0, (result, carMileage) -> {
					 if (result == 0)				return carMileage;
					 else if (carMileage < result)	return carMileage;
					 else							return result;}	);
        System.out.println("Minimum Car Mileage: " + maxMileage);
        
        int maxPrice = Car.stream().parallel().map((Car car) -> car.getPrice())
               .reduce(0, (result, carPrice) -> {
				   	if (result == 0)			return carPrice;
					else if (carPrice > result)	return carPrice;
					else						return result;}	);
        System.out.println("Maximum Car Price: $" + maxPrice);
       
        Integer avgPrice = Car.stream().parallel().map((Car car) -> car.getPrice())
                .reduce(0, (result,carPrice) -> result+carPrice, (finalResult, intermediateResult) -> finalResult)/Car.size();
        System.out.println("Average price of all Cars: $" + avgPrice);
        
        Integer carMakerNum = Car.stream().parallel().map( (Car car)-> car.getmake() )
                .reduce(0,(result,carMake)-> ++result,
                        (finalResult,intermediateResult)-> finalResult + intermediateResult);
        System.out.println("Total number of Car Makers: "+carMakerNum);

        Integer carModelNum = Car.stream().parallel().map( (Car car)-> car.getmodel() )
                .reduce(0,(result,carModel)-> ++result,
                        (finalResult,intermediateResult)-> finalResult + intermediateResult);
        System.out.println("Total number of Car Models: "+carModelNum);
        
    }

}