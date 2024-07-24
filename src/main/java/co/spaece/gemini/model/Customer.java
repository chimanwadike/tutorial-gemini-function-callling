package co.spaece.gemini.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@Column(length = 6)
	String id;
	String name;
	String city;
	String working_area;
	String country;
	Integer grade;
	Double opening_amount;
	Double receiving_amount;
	Double payment_amount;
	Double outstanding_amount;
	String phone_no;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getWorking_area() {
		return working_area;
	}
	
	public void setWorking_area(String working_area) {
		this.working_area = working_area;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Integer getGrade() {
		return grade;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	public Double getOpening_amount() {
		return opening_amount;
	}
	
	public void setOpening_amount(Double opening_amount) {
		this.opening_amount = opening_amount;
	}
	
	public Double getReceiving_amount() {
		return receiving_amount;
	}
	
	public void setReceiving_amount(Double receiving_amount) {
		this.receiving_amount = receiving_amount;
	}
	
	public Double getPayment_amount() {
		return payment_amount;
	}
	
	public void setPayment_amount(Double payment_amount) {
		this.payment_amount = payment_amount;
	}
	
	public Double getOutstanding_amount() {
		return outstanding_amount;
	}
	
	public void setOutstanding_amount(Double outstanding_amount) {
		this.outstanding_amount = outstanding_amount;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
}
