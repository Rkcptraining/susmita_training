package com.whatsappweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="myprofessor")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int p_id;
	private String p_name;
	private String p_subject;
	private String p_nature;
	
	@OneToMany(mappedBy = "pp")
	List<Student> slist=new ArrayList<Student>();
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_subject() {
		return p_subject;
	}
	public void setP_subject(String p_subject) {
		this.p_subject = p_subject;
	}
	public String getP_nature() {
		return p_nature;
	}
	public void setP_nature(String p_nature) {
		this.p_nature = p_nature;
	}
	
	
	
}
