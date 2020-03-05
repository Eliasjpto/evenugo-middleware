package com.evenugo.model;

public class Idioma {
private long PK=0;

public Idioma() {
}

public Idioma(long pK) {
	PK = pK;
}

public long getPK() {
	return PK;
}

public void setPK(long pK) {
	PK = pK;
}

@Override
public String toString() {
	return "Idioma [PK=" + PK + "]";
}

}
