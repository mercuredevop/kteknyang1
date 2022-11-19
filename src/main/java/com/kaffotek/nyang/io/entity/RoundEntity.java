package com.kaffotek.nyang.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

@Entity(name="rounds")
public class RoundEntity implements Serializable{
	
	private static final long serialVersionUID = 7809200551645852690L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length=30, nullable=false)
	private String roundId;
	
	@Column(nullable=false, length=50)
	private String name;
	
	@Column()
	private String image;
	
	@Column(nullable=false, length=50)
	private String starting_date;
	
	@Column(nullable=false, length=50)
	private String date;
	
	@Column(nullable=false)
	private int amount_expected;
	
	@Column(nullable=false)
	private int amount_collected;
	
	@Column(nullable=false)
	private int participants;
	
	@Column()
	private int numReviews;
	
	@Column()
	private int rating;
	
	@Column(nullable=false, length=50)
	private String beneficiary; //UserId one to one 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoundId() {
		return roundId;
	}

	public void setRoundId(String roundId) {
		this.roundId = roundId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStarting_date() {
		return starting_date;
	}

	public void setStarting_date(String starting_date) {
		this.starting_date = starting_date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String due_date) {
		this.date = due_date;
	}

	public int getAmount_expected() {
		return amount_expected;
	}

	public void setAmount_expected(int amount_expected) {
		this.amount_expected = amount_expected;
	}

	public int getAmount_collected() {
		return amount_collected;
	}

	public void setAmount_collected(int amount_collected) {
		this.amount_collected = amount_collected;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public int getNumReviews() {
		return numReviews;
	}

	public void setNumReviews(int numReviews) {
		this.numReviews = numReviews;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
