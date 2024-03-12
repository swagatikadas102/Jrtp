package in.ashokit.entity;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Detail")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer User_Id;
	private String Full_Name;
	private String Email;
	private Long Phone_no;
	private String Gender;
	private LocalDate DOB;
	private Long SSN;
	private String Active_Sw="Y";
	
	@CreationTimestamp
	private LocalDate Create_Date;
	@UpdateTimestamp
	private LocalDate Update_Date;
	
	
	public UserAccount() {
		 
	}
	public UserAccount(Integer user_Id, String full_Name, String email, Long phone_no, String gender, LocalDate dOB,
			Long sSN, String active_Sw, LocalDate create_Date, LocalDate update_Date) {
		super();
		User_Id = user_Id;
		Full_Name = full_Name;
		Email = email;
		Phone_no = phone_no;
		Gender = gender;
		DOB = dOB;
		SSN = sSN;
		Active_Sw = active_Sw;
		Create_Date = create_Date;
		Update_Date = update_Date;
	}
	
	
	public Integer getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(Integer user_Id) {
		User_Id = user_Id;
	}
	public String getFull_Name() {
		return Full_Name;
	}
	public void setFull_Name(String full_Name) {
		Full_Name = full_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Long getPhone_no() {
		return Phone_no;
	}
	public void setPhone_no(Long phone_no) {
		Phone_no = phone_no;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public Long getSSN() {
		return SSN;
	}
	public void setSSN(Long sSN) {
		SSN = sSN;
	}
	public String getActive_Sw() {
		return Active_Sw;
	}
	public void setActive_Sw(String active_Sw) {
		Active_Sw = active_Sw;
	}
	public LocalDate getCreate_Date() {
		return Create_Date;
	}
	public void setCreate_Date(LocalDate create_Date) {
		Create_Date = create_Date;
	}
	public LocalDate getUpdate_Date() {
		return Update_Date;
	}
	public void setUpdate_Date(LocalDate update_Date) {
		Update_Date = update_Date;
	}
	@Override
	public String toString() {
		return "UserEntity [User_Id=" + User_Id + ", Full_Name=" + Full_Name + ", Email=" + Email + ", Phone_no="
				+ Phone_no + ", Gender=" + Gender + ", DOB=" + DOB + ", SSN=" + SSN + ", Active_Sw=" + Active_Sw
				+ ", Create_Date=" + Create_Date + ", Update_Date=" + Update_Date + "]";
	}

	
	
	
	
}
