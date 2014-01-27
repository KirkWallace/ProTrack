package com.sideproj.protrack;

import java.util.Date;
/**
 * TimeEntry is used to store the specific information about a single clock in/out period
 * @author Wallace
 *
 */
public class TimeEntry {
	
	private boolean isGoing; //whether the clock in does not have an out time at the time of creation
	private boolean valid; //determines whether the entry is valid
	private boolean paid; //keeps track of paid-vs-unpaid hours
	private boolean Overtime; //set to true if already over 40hours
	
	private String tasks; //keeps the description of the work accomplished during clock in/out period
	private Date in;      //keeps track of the clock in time
	private Date out; 	  //keeps track of the clock out time

	
	
	
	/////////////Constructors//////////////////
	
	/**
	 * TimeEntry(Date) is used to create an ongoing time entry
	 * @param in
	 */
	public TimeEntry(Date in)
	{
		isGoing = true; //time entry is still current if only clock in is provided
		this.in = in;
	}
	/**
	 * Time Entry(Date,Date) is used to create an "old" or predefined time entry
	 * @param in : Date - clock in time
	 * @param out : Date - clock out time
	 */
	public TimeEntry(Date in, Date out)
	{
		isGoing = false; //since they provided the out time on creation this is an entry from the past
		this.in = in;
		this.out = out;
		validate();
	}
	
	
	///////////////Generic Methods//////////////////////
	
	/**
	 * void validate() is used after any call to set and checked before any call to get.  
	 */
	protected void validate()
	{
		if(!isGoing)
		{
			if(in.before(out)) //uses java.util.date's before() method
				valid = true;
			else 
				valid = false;
		}	
	}
	/**
	 * Create a before() method that supports use with TimeEntry. This simplifies code though is not necessary.
	 * @param challenger
	 * @return true if the challenger comes after the time entry this method is called on. 
	 */
	public boolean before(TimeEntry challenger)  {return in.before(challenger.getIn());}
	
	/**
	 * 
	 * @param challenger
	 * @return 0 if the clock in/out times of the challenger straddle either the clock in or out times of this time entry; 
	 * returns -1 if the challenger is completely before this time entry, and 1 if the challenger is completely after this time entry; 
	 * returns -2 if the challenger wraps this time entry, and 2 if this time entry wraps the challenger; Otherwise returns -4. 
	 */
	public int compareTo(TimeEntry challenger)
	{
		if(challenger.getIn().before(out) && challenger.getIn().after(in)&&challenger.getOut().after(out)) //straddles out
			return 0;
		else if(challenger.getOut().after(in) && challenger.getOut().before(out)&&challenger.getIn().before(in)) //straddles in
			return 0;
		else if(challenger.getIn().after(out) && challenger.getOut().after(out)) //challenger is completely after this entry
			return 1;
		else if(challenger.getIn().before(in) && challenger.getOut().before(in)) //challenger is completely before this entry
			return -1;
		else if(challenger.getIn().before(in) && challenger.getOut().after(out)) //challenger wraps this time entry
			return -2; 
		else if(challenger.getIn().after(in) && challenger.getOut().before(out)) //this time entry wraps challenger
			return 2;
		else return -4;
	}
	
	
	//////////////////////SETS///////////////////////////////
	
	/**
	 * void setPaid(boolean) sets whether the hours have been paid
	 * @param paid
	 */
	public void setPaid(boolean paid) {this.paid=paid;}

	/////////////////////GETS///////////////////////////////
	/**
	 * boolean getPaid() returns true if the hours have been paid 
	 * @return paid
	 */
	public boolean isPaid() {return paid;}
	
	/**
	 * double getHrsWorked() calculates and returns the number of hours between 
	 * clock in and clock out times.
	 * @return hoursWorked
	 */
	public double getHrsWorked()
	{	
		double hrs;  
			if(valid)
			{
			double year = (out.getYear()-in.getYear())*8760; //year difference converted to hours;
			double month = (out.getMonth()-in.getMonth())*(30.4*24.0);//30.4 = avg days in a month 
			double day = (out.getDate()-in.getDate())*24;
			double hour = out.getHours()-in.getHours();
			double min = (out.getMinutes()-in.getMinutes())/60.0;
			hrs = year + month + day + hour + min; 
			}
			else {
			hrs = -1.0;
			}
		return hrs; 
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public boolean isOvertime() {
		return Overtime;
	}
	public void setOvertime(boolean overtime) {
		Overtime = overtime;
	}
	public String getTasks() {
		return tasks;
	}
	public void setTasks(String tasks) {
		this.tasks = tasks;
	}
	public Date getIn() {
		return in;
	}
	public void setIn(Date in) {
		this.in = in;
	}
	public Date getOut() {
		return out;
	}
	public void setOut(Date out) {
		this.out = out;
	}
	public boolean isGoing() {
		return isGoing;
	}
	
	

}
