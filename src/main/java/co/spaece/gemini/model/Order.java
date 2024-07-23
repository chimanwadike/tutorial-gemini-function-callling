package co.spaece.gemini.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(length = 6)
	String id;
	Double order_amount;
	Double advance_amount;
	LocalDate order_date;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "agent_id")
	Agent agent;
	
	String order_description;
	
	public Agent getAgent() {
		return agent;
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Double getOrder_amount() {
		return order_amount;
	}
	
	public void setOrder_amount(Double order_amount) {
		this.order_amount = order_amount;
	}
	
	public Double getAdvance_amount() {
		return advance_amount;
	}
	
	public void setAdvance_amount(Double advance_amount) {
		this.advance_amount = advance_amount;
	}
	
	public LocalDate getOrder_date() {
		return order_date;
	}
	
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	
	public String getOrder_description() {
		return order_description;
	}
	
	public void setOrder_description(String order_description) {
		this.order_description = order_description;
	}
}
