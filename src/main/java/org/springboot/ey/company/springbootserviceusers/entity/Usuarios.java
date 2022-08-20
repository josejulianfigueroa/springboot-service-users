package org.springboot.ey.company.springbootserviceusers.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	@Email(message = "Email debe ser valido")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "created")
	@Temporal(TemporalType.DATE)
	private Date created;

	@Column(name = "modified")
	@Temporal(TemporalType.DATE)
	private Date modified;

	@Column(name = "last_login")
	@Temporal(TemporalType.DATE)
	private Date last_login;

	@Column(name = "token")
	private String token;

	@Column(name = "isactive")
	private Boolean isactive;

	/*@OneToOne( mappedBy = "user", cascade = CascadeType.ALL )
	private Telefonos phones;*/

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

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1285454306356845809L;

}
