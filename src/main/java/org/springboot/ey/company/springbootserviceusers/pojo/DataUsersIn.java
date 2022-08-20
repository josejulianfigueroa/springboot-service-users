package org.springboot.ey.company.springbootserviceusers.pojo;

import org.springboot.ey.company.springbootserviceusers.entity.Telefonos;

import java.io.Serializable;
import java.util.List;

public class DataUsersIn implements Serializable {

	private String name;
	private String email;
	private String password;
	private List<Telefonos> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Telefonos> getPhones() {
		return phones;
	}

	public void setPhones(List<Telefonos> phones) {
		this.phones = phones;
	}
}
