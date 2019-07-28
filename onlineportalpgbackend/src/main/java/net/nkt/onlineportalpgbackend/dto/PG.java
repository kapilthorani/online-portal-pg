package net.nkt.onlineportalpgbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PG {
	
	// private fields
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name ="bookcode")
		private String bookingCode;
		private String name;
		private int rent;
		private String gender;
		private String location;
		private String pgtype;
		@Column(name ="bed_available")
		private int bedAvailable;
		@JsonIgnore
		private String description;
		@Column(name ="is_active")
		@JsonIgnore
		private boolean active; 
		@Column(name ="category_id")
		@JsonIgnore
		private int categoryId;
		@Column(name ="owner_id")
		@JsonIgnore
		private int ownerId;
		private int views;
		
	// default contr
	public PG() {
		this.bookingCode = "PG" +UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	//getter and setter	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPgtype() {
		return pgtype;
	}

	public void setPgtype(String pgtype) {
		this.pgtype = pgtype;
	}

	public int getBedAvailable() {
		return bedAvailable;
	}

	public void setBedAvailable(int bedAvailable) {
		this.bedAvailable = bedAvailable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	//to string 

	@Override
	public String toString() {
		return "PG [id=" + id + ", bookingCode=" + bookingCode + ", name=" + name + ", rent=" + rent + ", gender="
				+ gender + ", location=" + location + ", pgtype=" + pgtype + ", bedAvailable=" + bedAvailable
				+ ", description=" + description + ", active=" + active + ", categoryId=" + categoryId + ", ownerId="
				+ ownerId + ", views=" + views + "]";
	}
	
	
	
}
