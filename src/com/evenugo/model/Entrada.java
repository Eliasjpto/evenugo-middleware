package com.evenugo.model;

public class Entrada {
	
	private long localizador=0;
	private long idEvento;	
	private int numero=0; // numero consecutivo entre 1 y aforo
	private double precio=0.0d;	
	private long idUsuario;
	public Entrada() {
		super();
	}
	public Entrada(long localizador, long idEvento, int numero, double precio, long idUsuario) {
		super();
		this.localizador = localizador;
		this.idEvento = idEvento;
		this.numero = numero;
		this.precio = precio;
		this.idUsuario = idUsuario;
	}
	public long getLocalizador() {
		return localizador;
	}
	public void setLocalizador(long localizador) {
		this.localizador = localizador;
	}
	public long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	

	
	

}
