package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "meter_details")

public class Meter {
	
	public Meter() {
		super();
	}
	
	public Meter(long meterNo, String meterName) {
		super();
		this.meterNo = meterNo;
		this.meterName = meterName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "meter_no")
	private long meterNo;
	
	@Column(name = "meter_name")
	private String meterName;
	
//	@ManyToOne
//	@JoinColumn(name = "id")
//	private User user;
//	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public long getId() {
		return id;
	}
	public long getMeterNo() {
		return meterNo;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public void setMeterNo(long meterNo) {
		this.meterNo = meterNo;
	}
	public String getMeterName() {
		return meterName;
	}
	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}	
}