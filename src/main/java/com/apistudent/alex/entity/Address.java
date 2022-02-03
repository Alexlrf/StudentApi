package com.apistudent.alex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Audited
@AuditTable(value = "address_mirror")
@Entity(name = "address")
public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_address")
	private Long idAddress;
	
	@Column(name = "house_number")
	@JsonProperty("houseNumber")
	private int houseNumber;
	
	@Column(name = "street")
	@JsonProperty("street")
	private String street;
	
	@Column(name = "district")
	@JsonProperty("district")
	private String district;
	
	@Column(name = "city")
	@JsonProperty("city")
	private String city;
	
	@Column(name = "state")
	@JsonProperty("state")
	private String state;
	
	@Column(name = "complement")
	@JsonProperty("complement")
	private String complement;
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_student")
	@JsonBackReference
	private Student student;

	public Long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [idAddress=" + idAddress + ", houseNumber=" + houseNumber + ", street=" + street + ", district="
				+ district + ", city=" + city + ", state=" + state + ", complement=" + complement + ", student="
				+ student + "]";
	}	
	
}
