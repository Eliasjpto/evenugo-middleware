package com.evenugo.model;

public class Promotor {
private long PK=0;
private String nombre=null;
private Sexo s;
public Promotor () {
	
}
public Promotor(long pK, String nombre, Sexo s) {
	super();
	PK = pK;
	this.nombre = nombre;
	this.s = s;
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
public Sexo getS() {
	return s;
}
public void setS(Sexo s) {
	this.s = s;
}
@Override
public String toString() {
	return "Promotor [PK=" + PK + ", nombre=" + nombre + ", s=" + s + "]";
}

}
