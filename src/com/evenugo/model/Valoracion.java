package com.evenugo.model;

public class Valoracion {
private long valoracion=0;
private Evento e;
private Usuario u;
public Valoracion() {
}
public Valoracion(long valoracion, Evento e, Usuario u) {
	this.valoracion = valoracion;
	this.e = e;
	this.u = u;
}
public long getValoracion() {
	return valoracion;
}
public void setValoracion(long valoracion) {
	this.valoracion = valoracion;
}
public Evento getE() {
	return e;
}
public void setE(Evento e) {
	this.e = e;
}
public Usuario getU() {
	return u;
}
public void setU(Usuario u) {
	this.u = u;
}

}
