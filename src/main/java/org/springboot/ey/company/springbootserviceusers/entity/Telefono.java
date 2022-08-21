package org.springboot.ey.company.springbootserviceusers.entity;

import javax.persistence.*;

@Entity
@Table(name = "telefonos")
public class Telefono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "number")
	private String number;

	@Column(name = "citycode")
	private String citycode;

	@Column(name = "contrycode")
	private String contrycode;

	@Column(name = "iduser")
	private Long iduser;

	public Telefono(String number, String citycode, String contrycode, Long iduser) {
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
		this.iduser = iduser;
	}

	public Telefono(String number, String citycode, String contrycode) {
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
	}

	public Telefono() {

	}

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public Long getId() {
		return id;
	}

	public Telefono setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNumber() {
		return number;
	}

	public Telefono setNumber(String number) {
		this.number = number;
		return this;
	}

	public String getCitycode() {
		return citycode;
	}

	public Telefono setCitycode(String citycode) {
		this.citycode = citycode;
		return this;
	}

	public String getContrycode() {
		return contrycode;
	}

	public Telefono setContrycode(String contrycode) {
		this.contrycode = contrycode;
		return this;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1285454306356845879L;

}
