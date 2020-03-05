package com.evenugo.model;

public class Localidad {
	
	private long PK=0;
	private String nombre=null;
	private long idProvincia;
	
	
	public Localidad() {
		super();
	}


	public long getPK() {
		return PK;
	}


	public void setPK(long pK) {
		PK = pK;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public long getIdProvincia() {
		return idProvincia;
	}


	public void setIdProvincia(long idProvincia) {
		this.idProvincia = idProvincia;
	}
	




}
