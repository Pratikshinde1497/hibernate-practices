package com.shinde.telusko.hibernate.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class Student {

	@Id
	private int rno;
	private String sname;
	private int marks;
	@ManyToMany(mappedBy = "student")
	private List<Laptop> laptop = new ArrayList<Laptop>();

	//  specifies that laptop table is taking care of many to many relation | 
	//	doesnt create one more table: student_laptop
	//	"student" is the object that we  have created in laptop's table
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", sname=" + sname + ", marks=" + marks + "]";
	}	
}
