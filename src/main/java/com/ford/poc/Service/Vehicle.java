package com.ford.poc.Service;

import javax.persistence.Entity;

@Entity
public class Vehicle {
	
	public String trim;
	public String year;

	public String getTrim() {
		return trim;
	}
	public void setTrim(String trim) {
		this.trim = trim;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}
