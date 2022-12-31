package controllers;

public class FlightModel {
	
	String flightid, tocity, arrivedate,arrivetime,fromcity, departdate, departtime;

	public FlightModel (String flightid, String tocity, String arrivedate, String arrivetime, String fromcity, String departdate, String departtime) {
		this.flightid = flightid;
		this.tocity = tocity;
		this.arrivedate = arrivedate;
		this.arrivetime = arrivetime;
		this.fromcity = fromcity;
		this.departdate = departdate;
		this.departtime = departtime;
	
	}

	public String getFlightid() {
		return flightid;
	}

	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}

	public String getTocity() {
		return tocity;
	}

	public void setTocity(String tocity) {
		this.tocity = tocity;
	}

	public String getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(String arrivedate) {
		this.arrivedate = arrivedate;
	}

	public String getArrivetime() {
		return arrivetime;
	}

	public void setArrivetime(String arrivetime) {
		this.arrivetime = arrivetime;
	}

	public String getFromcity() {
		return fromcity;
	}

	public void setFromcity(String fromcity) {
		this.fromcity = fromcity;
	}

	public String getDepartdate() {
		return departdate;
	}

	public void setDepartdate(String departdate) {
		this.departdate = departdate;
	}

	public String getDeparttime() {
		return departtime;
	}

	public void setDeparttime(String departtime) {
		this.departtime = departtime;
	}

	
	
}
	
	
	
	
	
	