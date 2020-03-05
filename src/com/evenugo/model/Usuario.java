package com.evenugo.model;
import java.util.Date;

public class Usuario {
	private String nombre = null;
	private String apellidos = null;
	private String direccion =null;
	private long localidad;
	private Date fechaNacimiento;
	private long PK=0;
	private String password=null;
	private String telefono=null;
	private String email=null;
	private String sexo=null;
	public Usuario() {	
	}
	public Usuario(String nombre, String apellidos, String direccion, long localidad, Date fechaNacimiento, long pK,
			String password, String telefono, String email, String sexo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.localidad = localidad;
		this.fechaNacimiento = fechaNacimiento;
		PK = pK;
		this.password = password;
		this.telefono = telefono;
		this.email = email;
		this.sexo = sexo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public long getLocalidad() {
		return localidad;
	}
	public void setLocalidad(long localidad) {
		this.localidad = localidad;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public long getPK() {
		return PK;
	}
	public void setPK(long pK) {
		PK = pK;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	


}
