package co.spaece.gemini.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agents")
public class Agent {
	@Id
	@Column(length = 6)
	String id;
	String agent_name;
	String working_area;
	String commission;
	String phone_no;
	String country;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAgent_name() {
		return agent_name;
	}
	
	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}
	
	public String getWorking_area() {
		return working_area;
	}
	
	public void setWorking_area(String working_area) {
		this.working_area = working_area;
	}
	
	public String getCommission() {
		return commission;
	}
	
	public void setCommission(String commission) {
		this.commission = commission;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
}
