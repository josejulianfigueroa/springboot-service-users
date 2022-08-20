package org.springboot.ey.company.springbootserviceusers.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email", unique=true)
	@NotNull
	@NotBlank(message = "Email no puede ir vacío")
	@NotEmpty(message = "Debe informar email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "created")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/YYYY")
	private Date created;

	@Column(name = "modified")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/YYYY")
	private Date modified;

	@Column(name = "last_login")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/YYYY")
	private Date last_login;

	@Column(name = "token")
	private String token;

	@Column(name = "isactive")
	private Boolean isactive;

	/*@OneToOne( mappedBy = "user", cascade = CascadeType.ALL )
	private Telefonos phones;*/

	public Usuario(String name, String email, String password, Date created, Date modified, Date last_login, String token, Boolean isactive) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.token = token;
		this.isactive = isactive;
	}

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public Usuario setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Usuario setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Usuario setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Usuario setPassword(String password) {
		this.password = password;
		return this;
	}

	public Date getCreated() {
		return created;
	}

	public Usuario setCreated(Date created) {
		this.created = created;
		return this;
	}

	public Date getModified() {
		return modified;
	}

	public Usuario setModified(Date modified) {
		this.modified = modified;
		return this;
	}

	public Date getLast_login() {
		return last_login;
	}

	public Usuario setLast_login(Date last_login) {
		this.last_login = last_login;
		return this;
	}

	public String getToken() {
		return token;
	}

	public Usuario setToken(String token) {
		this.token = token;
		return this;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public Usuario setIsactive(Boolean isactive) {
		this.isactive = isactive;
		return this;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1285454306356845809L;

}
