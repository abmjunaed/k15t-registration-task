package com.k15t.pat.server.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.k15t.pat.server.validator.ValidEmail;
import com.k15t.pat.server.validator.ValidName;
import com.k15t.pat.server.validator.ValidPassword;



@ValidPassword(message = "{registration.validation.password.mismatch}")
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "{registration.validation.firstName}")
	@NotEmpty(message = "{registration.validation.firstName}")
	@ValidName(message = "{registration.validation.name.should.not.be.number}")
	private String firstName;

	@NotNull(message = "{registration.validation.lastName}")
	@NotEmpty(message = "{registration.validation.lastName}")
	@ValidName(message = "{registration.validation.name.should.not.be.number}")
	private String lastName;

	@NotNull(message = "{registration.validation.email}")
	@NotEmpty(message = "{registration.validation.email}")
	@ValidEmail(message = "{registration.validation.email}")
	private String email;

	@NotNull(message = "{registration.validation.password}")
	@NotEmpty(message = "{registration.validation.password}")
	@Size(min = 8, max = 16)
	private String password;

	@NotNull(message = "{registration.validation.password}")
	@NotEmpty(message = "{registration.validation.password}")
	private String matchingPassword;

	@NotNull(message = "{registration.validation.street}")
	@NotEmpty(message = "{registration.validation.street}")
	private String street;

	@NotNull(message = "{registration.validation.houseNumber}")
	@NotEmpty(message = "{registration.validation.houseNumber}")
	private String houseNumber;

	private String additional;

	@NotNull(message = "{registration.validation.city}")
	@NotEmpty(message = "{registration.validation.city}")
	private String city;

	@NotNull(message = "{registration.validation.zip}")
	@NotEmpty(message = "{registration.validation.zip}")
	private String zip;

	@NotNull(message = "{registration.validation.country}")
	@NotEmpty(message = "{registration.validation.country}")
	private String country;
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String area) {
		this.city = area;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
