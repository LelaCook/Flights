package controllers;

public class FlightModel {
	Integer flightid;
	String tocity, arrivedate,arrivetime,departdate, departtime;






	public FlightModel (Integer flightid, String tocity, String arrivedate, String arrivetime,String departdate, String departtime) {
		this.flightid = flightid;
		this.tocity = tocity;
		this.arrivedate = arrivedate;
		this.arrivetime = arrivetime;
		this.departdate = departdate;
		this.departtime = departtime;
	
}

	public Integer getFlightid () {
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
	
	public String getDepartDate () {
		return departdate;

	}
	
	public String getDepartTime () {
		return departtime;

}
	
	
	
	
	public void setFlightid (Integer flightid) {
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
	
	public void setDepartDate (String departdate) {
		this.departdate = departdate;
	
	}
	
	
	public void setDepartTime (String departtime) {
		this.departtime = departtime;
	
	}
}
	
	
	
	
	
	