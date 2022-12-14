package com.oee.practica.usuarios.entity;


import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity
@Table(name="usuarios",uniqueConstraints = { @UniqueConstraint(columnNames = {"email"}) })
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private Integer edad;
	
	@Column(unique=true,nullable = false)
	private String email;
	

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="usuarios_roles", joinColumns=@JoinColumn(name="usuario_id"), 
	inverseJoinColumns=@JoinColumn(name="role_id"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"usuario_id","role_id"})})
	private List<Role> roles;
	
	@Column(length = 65, nullable = false)
	private String password;
	
	private Boolean enabled=true;
	
	
	public Boolean getEnabled() {
		return enabled;
	}

	public Usuario() {}
	

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
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
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}  

	

}
