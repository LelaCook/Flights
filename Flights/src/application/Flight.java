package application;

import java.util.Date;

public class Flight {
	
	int id, capacity, filled;
	Date arriveTime, departTime;
	String fromCity,toCity;

	public Flight(){	
	}
	
	public int getId() {
		return id;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getFilled() {
		return filled;
	}
	
	public Date getArriveTime() {
		return arriveTime;
	}
	
	public Date getDepartTime() {
		return departTime;
	}
	
	public String getFromCity() {
		return fromCity;
	}
	
	public String getToCity() {
		return toCity;
	}
	
}
