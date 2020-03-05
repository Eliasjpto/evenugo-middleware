package com.evenugo.model;

public class Provincia {
private long PK=0;
private String nombre=null;
Pais p=null;
public Provincia() {
}
public Provincia(long pK, String nombre, Pais p) {
	super();
	PK = pK;
	this.nombre = nombre;
	this.p = p;
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
public Pais getP() {
	return p;
}
public void setP(Pais p) {
	this.p = p;
}
@Override
public String toString() {
	return "Provincia [PK=" + PK + ", nombre=" + nombre + ", p=" + p + "]";
}

}
