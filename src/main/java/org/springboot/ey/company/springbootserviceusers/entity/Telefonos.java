package org.springboot.ey.company.springbootserviceusers.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "telefonos")
public class Telefonos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "number")
	private String number;

	@Column(name = "citycode")
	private String citycode;

	@Column(name = "contrycode")
	private String contrycode;

	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn(name = "id_user")
	private Usuarios user;


	Telefonos(){}
	public Usuarios getUser() {
		return user;
	}

	public void setUser(Usuarios user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1285454306356845879L;

	public Telefonos(String number, String citycode, String contrycode, Usuarios user) {
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
		this.user = user;
	}
}
