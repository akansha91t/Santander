package com.santander.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	private String Id;
	
	@NotNull
	@Email(message="sender should be email")
	private String sender;
	@NotNull
	@Email(message="receiver should be email")
	private String receiver;
	@NotNull
	private double amount;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(String id, @NotNull @Email String sender, @NotNull @Email String receiver,
			@NotNull double amount) {
		super();
		Id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String reciever) {
		this.receiver = reciever;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [Id=" + Id + ", sender=" + sender + ", receiver=" + receiver + ", amount=" + amount + "]";
	}
}
