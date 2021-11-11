package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "meter_data")

public class MeterData {

	public MeterData() {
		super();
	}

	public MeterData(String month, double cost, Date string, Date string2, String paymentMode, String i) {
		super();
		this.month = month;
		this.cost = cost;
		this.dueDate = string;
		this.paymentDate = string2;
		this.paymentMode = paymentMode;
		this.paymentId = i;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "cost")
	private double cost;
	
	@Column(name = "due_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dueDate;
	
	@Column(name = "payment_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date paymentDate;
	
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name = "payment_id")
	private String paymentId;
	
	@ManyToOne
	@JoinColumn(name = "meter_id")
	private Meter meter;
	
	public Meter getMeter() {
		return meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}

	public String getMonth() {
		return month;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

}
