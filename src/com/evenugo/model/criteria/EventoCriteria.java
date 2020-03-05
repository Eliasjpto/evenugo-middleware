package com.evenugo.model.criteria;

import java.util.Date;

public class EventoCriteria {

	private String nombre = null;
	
	private Integer valoracionMin = null;
	
	private Date fechaDesde = null;
	private Date fechaHasta = null;
	
	private Long idLocalidad = null;
	
	private Long idTipoEvento = null;
	
	
	
	public EventoCriteria() {		
	}



	public EventoCriteria(String nombre, Integer valoracionMin, Date fechaDesde, Date fechaHasta, Long idLocalidad,
			Long idTipoEvento) {
		super();
		this.nombre = nombre;
		this.valoracionMin = valoracionMin;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.idLocalidad = idLocalidad;
		this.idTipoEvento = idTipoEvento;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getValoracionMin() {
		return valoracionMin;
	}



	public void setValoracionMin(Integer valoracionMin) {
		this.valoracionMin = valoracionMin;
	}



	public Date getFechaDesde() {
		return fechaDesde;
	}



	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}



	public Date getFechaHasta() {
		return fechaHasta;
	}



	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}



	public Long getIdLocalidad() {
		return idLocalidad;
	}



	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}



	public Long getIdTipoEvento() {
		return idTipoEvento;
	}



	public void setIdTipoEvento(Long idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}


}
