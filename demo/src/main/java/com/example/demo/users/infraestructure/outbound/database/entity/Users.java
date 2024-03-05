package com.example.demo.users.infraestructure.outbound.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	private String usr;	
	
	@Column(name = "password")
	private String password;

	public String getUsr() {
		return usr;
	}

	public String getPassword() {
		return password;
	}

	
}
