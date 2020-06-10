package it.polito.tdp.bar.model;

public class Tavolo {
Integer posti;
boolean occupato;
int id;

@Override
public String toString() {
	return "Tavolo [posti=" + posti + ", occupato=" + occupato + ", id=" + id + "]";
}
public Tavolo(Integer posti, boolean occupato,int id) {
	super();
	this.posti = posti ;
	this.occupato = occupato;
	this.id=id;
}
public Integer getPosti() {
	return posti;
}
public boolean isOccupato() {
	return occupato;
}
public void setPosti(Integer posti) {
	this.posti = posti;
}
public void setOccupato() {
	this.occupato = true;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + (occupato ? 1231 : 1237);
	result = prime * result + ((posti == null) ? 0 : posti.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Tavolo other = (Tavolo) obj;
	if (id != other.id)
		return false;
	if (occupato != other.occupato)
		return false;
	if (posti == null) {
		if (other.posti != null)
			return false;
	} else if (!posti.equals(other.posti))
		return false;
	return true;
}
public int getId() {
	// TODO Auto-generated method stub
	return id;
}

}
