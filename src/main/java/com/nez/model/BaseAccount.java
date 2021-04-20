package com.nez.model;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class BaseAccount extends Person{
	static public enum UserRole {ROLE_Admin, ROLE_User};
	static public enum Gender {Male, Female};
	
	protected String username;
	protected String password;
	protected String email;
	protected String telephone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate birthDate;
	protected String photo;
	@Enumerated(EnumType.STRING)
	protected Gender gender;
	protected String address;
	protected boolean isVerified;
	protected String personalId;
	@Enumerated(EnumType.STRING)
	protected UserRole role = UserRole.ROLE_User;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getPersonalId() {
		return personalId;
	}
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "BaseAccount [username=" + username + ", password=" + password + ", email=" + email + ", telephone="
				+ telephone + ", birthDate=" + birthDate + ", photo=" + photo + ", gender=" + gender + ", address="
				+ address + ", isVerified=" + isVerified + ", personalId=" + personalId + ", role=" + role + "]";
	}
	
	
}
