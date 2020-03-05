package com.evenugo.model;


public class TipoEvento {

	private long pk=0;
	private String nombre=null;
	private String idioma=null;
	public TipoEvento() {
		super();
	}
	public TipoEvento(long pk, String nombre, String idioma) {
		super();
		this.pk = pk;
		this.nombre = nombre;
		this.idioma = idioma;
	}
	public long getPk() {
		return pk;
	}
	public void setPk(long pk) {
		this.pk = pk;
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



}