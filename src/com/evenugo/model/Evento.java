package com.evenugo.model;
import java.util.Date;

public class Evento {
	// private Date fechaDesde a hasta
	private long PK = 0;
	private long idTipoEvento;
	private long idPromotor;
	private String direccion=null;
	private String nombre = null;
	private String descripcion = null;
	private long idLocalidad;
	private String nombreLocalidad;	
	private Date fecha;
	private int aforo=0;
	private double precio=0.0;
	private double valoracionMedia = 0.0d;

	public Evento() {
	}

	
	public Evento(long pK, long idTipoEvento, long idPromotor, String direccion, String nombre, String descripcion,
			long idLocalidad, Date fecha, int aforo, double precio) {
		super();
		PK = pK;
		this.idTipoEvento = idTipoEvento;
		this.idPromotor = idPromotor;
		this.direccion = direccion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.idLocalidad = idLocalidad;
		this.fecha = fecha;
		this.aforo = aforo;
		this.precio = precio;
	}

	public long getPK() {
		return PK;
	}

	public void setPK(long pK) {
		PK = pK;
	}

	public long getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(long idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public long getIdPromotor() {
		return idPromotor;
	}

	public void setIdPromotor(long idPromotor) {
		this.idPromotor = idPromotor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getValoracionMedia() {
		return valoracionMedia;
	}

	public void setValoracionMedia(double valoracionMedia) {
		this.valoracionMedia = valoracionMedia;
	}

	@Override
	public String toString() {
		return "Evento [PK=" + PK + ", idTipoEvento=" + idTipoEvento + ", idPromotor=" + idPromotor + ", direccion="
				+ direccion + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idLocalidad=" + idLocalidad
				+ ", fecha=" + fecha + ", aforo=" + aforo + ", precio=" + precio + ", valoracionMedia = "+valoracionMedia+"]";
	}
}