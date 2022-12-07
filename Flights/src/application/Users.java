package application;

import setup.ArrayList;
import setup.Integer;
import setup.String;
import setup.User;
import setup.string;

public class Users {

}

abstract class User {
	
	private String firstName;
	private String lastName;
	private String address;
	private int zipCode;
	private String state;
	private String username;
	private String password;
	private String email;
	private int ssn;
	private int securityQuestion;
	private String answer;
	
	//ArrayList<Integer> flights = new ArrayList<>();
	
	protected User() {
	}
	
	// all setting up variables 
	public void setFirst(String h) {
		this.firstName = h;	
	}
	
	public void setLast(String j) {
		this.lastName = j;
	}
	
	public void setAddress(String k) {
		this.address = k;
	}
	
	public void setZip(int l) {
		this.zipCode = l;
	}
	
	public void setState(String a) {
		this.state = a;
	}
	
	public void setUsername(String s) {
		this.username = s;
	}
	
	public void setPassword(String d) {
		this.password = d;
	}
	
	public void setEmail(String f) {
		this.email = f;
	}
	
	public void setSSN(int g) {
		this.ssn = g;
	}
	
	public void whichQuestion(int q) {
		this.securityQuestion = q;
	}
	
	public void setAnswer(String w) {
		this.answer = w;
	}
	
	// Flights on account
	public void bookFlight(int e) {
		flights.add(e);
	}
	
	public void removeFlight(int r) {
		flights.remove(r);
	}
	
}

class Customer extends User {
	
	boolean isAdmin = false;
	
	Customer(){
	}
	
}

class Admin extends User {
	
	boolean isAdmin = true;
	
	Admin(){
	}
	
}

class Flight {
	
	String city;
	int id;
	// Arrive
	int aMonth;
	int aDay;
	int aHour;
	int aMinute;
	// Depart
	int dMonth;
	int dDay;
	int dHour;
	int dMinute;
	int capacity;
	int filled;
	
	Flight() {
	}
	
	Flight(int t, String y, int u) {
		id = t;
		city = y;
		capacity = u;
	}
	
	// Setting times
	public void setArrive(int z, int x, int c, int v) {
		this.aMonth = z;
		this.aDay = x;
		this.aHour = c;
		this.aMinute = v;
	}
	
	public void setDepart(int z, int x, int c, int v) {
		this.dMonth = z;
		this.dDay = x;
		this.dHour = c;
		this.dMinute = v;
	}
	
	// Setting seats
	public void addFilled() {
		filled++;
	}
	
	public void subFilled() {
		filled--;
	}
	
}
