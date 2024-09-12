package com.entities;

public class Truck {
    
	//data member(Attributes)
	private int truckId;
	private String truckName;
	private String capacity;
	private String truckNumber;
	
	
    //default constructor
	public Truck() {
		super();
	}

	//to string method
	@Override
	public String toString() {
		return "Truck{" + "truckId=" + truckId + ", truckName='" + truckName + '\'' + ", capacity='" + capacity + '\''
				+ ", truckNumber='" + truckNumber + '\'' + '}';
	}

	//All getter & setters
	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}

	//parameterized constructor
	public Truck(String truckName, String truckNumber, String capacity) {
		this.truckName = truckName;
		this.truckNumber = truckNumber;
		this.capacity = capacity;
	}

}
