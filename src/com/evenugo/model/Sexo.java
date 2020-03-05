package com.evenugo.model;

public class Sexo {
private char PK;

public Sexo() {
	super();
}

public Sexo(char pK) {
	super();
	PK = pK;
}

public char getPK() {
	return PK;
}

public void setPK(char pK) {
	PK = pK;
}

@Override
public String toString() {
	return "Sexo [PK=" + PK + "]";
}

}
