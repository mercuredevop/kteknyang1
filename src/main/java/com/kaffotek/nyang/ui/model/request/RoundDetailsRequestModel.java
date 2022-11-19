package com.kaffotek.nyang.ui.model.request;

public class RoundDetailsRequestModel {
	
	private String name;
	private String image;
	private String starting_date;
	private String date;
	private int amount_expected;
	private int amount_collected;
	private int participants;
	private int numReviews;
	private int rating;
	private String beneficiary;
	
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
	public void setDate(String date) {
		this.date = date;
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


}
