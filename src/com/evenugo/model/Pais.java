package com.evenugo.model;

public class Pais {
	private long PK = 0;
	private String nombre = null;
	private String idioma=null ;
	public Pais() {
		super();
	}
	
	public Pais(long pk,String nombre) {
		PK = pk;
		this.nombre = nombre;
	}
	public Pais(long pK, String nombre, String idioma) {
		PK = pK;
		this.nombre = nombre;
		this.idioma = idioma;
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
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public String toString() {
		return "Pais [PK=" + PK + ", nombre=" + nombre + ", idioma=" + idioma + "]";
	}
	
}
