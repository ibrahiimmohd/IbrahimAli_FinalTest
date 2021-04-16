/*  
 * Ibrahim Ali
 * 301022172
 * 16-04-2021
 * */

package com.spring.finaltest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name="customerrecord")
public class CustomerRecord {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
    @NotBlank(message = "Customer first name is mandatory")
    private String customerFirstName;
    
    @NotBlank(message = "Customer last name is mandatory")
    private String customerLastName;
    
    @NotBlank(message = "Customer email is mandatory")
    private String customerEmail;
    
    @NotBlank(message = "Phone is mandatory")
    private String phone;
    
    @NotBlank(message = "Address line 1 is mandatory")
    private String addressLine1;
    
    private String addressLine2;
    
    @NotBlank(message = "City is mandatory")
    private String city;
    
    @NotBlank(message = "State is mandatory")
    private String state;
    
    @NotBlank(message = "Postal Code is mandatory")
    private String postalCode;
    
    @NotNull
    private int creditLimit;
    
    public CustomerRecord() {}
    
    public CustomerRecord(String customerFirstName, String customerLastName, String customerEmail, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, int creditLimit)
    {
    	this.customerFirstName = customerFirstName;
    	this.customerLastName = customerLastName;
    	this.customerEmail = customerEmail;
    	this.phone = phone;
    	this.addressLine1 = addressLine1;
    	this.addressLine2 = addressLine2;
    	this.city = city;
    	this.state = state;
    	this.postalCode = postalCode;
    	this.creditLimit = creditLimit;
    }
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}
}

