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

	public String getFlightid () {
		return flightid;
		
	}
	
	public String getToCity () {
		return tocity;
		
	}
	
	public String getArriveDate () {
		return arrivedate;
		
	}
	
	public String getArriveTime () {
		return arrivetime;
	}
	
	public String getFromCity () {
		return fromcity;
		
	}
	
	public String getDepartDate () {
		return departdate;

	}
	
	public String getDepartTime () {
		return departtime;

	}
	
	
	
	
	public void setFlightid (String flightid) {
		this.flightid = flightid;
	
	}
	
	public void setToCity (String tocity) {
		this.tocity = tocity;
	
	}
	
	public void setArriveDate (String arrivedate) {
		this.arrivedate = arrivedate;
	
	}
	public void setArriveTime (String arrivetime) {
		this.arrivetime = arrivetime;
	
	}

	public void setFromCity (String fromcity) {
		this.fromcity = fromcity;
	
	}
	
	public void setDepartDate (String departdate) {
		this.departdate = departdate;
	
	}	
	
	public void setDepartTime (String departtime) {
		this.departtime = departtime;
	
	}
	
}
	
	
	
	
	
	