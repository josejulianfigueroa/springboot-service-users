package org.springboot.ey.company.springbootserviceusers.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.springboot.ey.company.springbootserviceusers.security.entity.Rol;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuarios {

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

	public Usuarios(String name, String email, String password, Date created, Date modified, Date last_login, String token, Boolean isactive) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.token = token;
		this.isactive = isactive;
	}

	public Usuarios() {
	}

	public Long getId() {
		return id;
	}

	public Usuarios setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Usuarios setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Usuarios setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Usuarios setPassword(String password) {
		this.password = password;
		return this;
	}

	public Date getCreated() {
		return created;
	}

	public Usuarios setCreated(Date created) {
		this.created = created;
		return this;
	}

	public Date getModified() {
		return modified;
	}

	public Usuarios setModified(Date modified) {
		this.modified = modified;
		return this;
	}

	public Date getLast_login() {
		return last_login;
	}

	public Usuarios setLast_login(Date last_login) {
		this.last_login = last_login;
		return this;
	}

	public String getToken() {
		return token;
	}

	public Usuarios setToken(String token) {
		this.token = token;
		return this;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public Usuarios setIsactive(Boolean isactive) {
		this.isactive = isactive;
		return this;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1285454306356845809L;

}
