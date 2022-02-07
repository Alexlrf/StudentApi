package com.apistudent.alex.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.apistudent.alex.domain.MaritalStatus;
import com.apistudent.alex.repository.PostgreSQLEnumType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Audited
@AuditTable(value = "student_mirror")
@Entity(name = "student")
@TypeDef(
	    name = "pgsql_enum", // valor Default - não é preciso mudar
	    typeClass = PostgreSQLEnumType.class)
public class Student{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_student")
	private Long idStudent;
	
	@NotBlank(message = "{name.not.blank}")
	@Column(name = "firstname")
	@JsonProperty("firstname")
	private String firstname;

	@NotBlank(message = "{lastname.not.blank}")
	@Column(name = "lastname")
	@JsonProperty("lastname")
	private String lastname;

	@NotBlank
	@Size(min=5)
	@Column(name = "phone")
	@JsonProperty("phone")
	private String phone;
	
	@NotBlank(message = "{email.not.blank}")
	@Email
	@Column(name = "email")
	@JsonProperty("email")
	private String email;
	
//	@NotBlank(message = "{maritalStatus.not.blank}")
	@Column(name = "marital_status_enum", columnDefinition = "marital_status") // marital_status é o Type criado no Postgres
	@JsonProperty("maritalStatus")
	@Enumerated(EnumType.STRING)	
	@Type( type = "pgsql_enum" )
	private MaritalStatus maritalStatus;
	
	@Column(name = "address")
	@JsonProperty("address")
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Address> address;

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", firstname=" + firstname + ", lastname=" + lastname + ", phone="
				+ phone + ", email=" + email + ", maritalStatus=" + maritalStatus + ", address=" + address + "]";
	}	

}
