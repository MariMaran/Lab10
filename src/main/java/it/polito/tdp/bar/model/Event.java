package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.List;

public class Event implements Comparable<Event>{
Integer tempo;
int numPersone;
int idTavolo;
public int getIdTavolo() {
	return idTavolo;
}
public void setIdTavolo(int idTavolo) {
	this.idTavolo = idTavolo;
}
public enum EventType {
	NEW_CLIENTS, TABLE_RETURNED
	
}
EventType tipo;
public Event(int tempo, int numPersone, EventType tipo) {
	this.tempo = tempo;
	this.numPersone = numPersone;
	this.tipo = tipo;
}
public int getTempo() {
	return tempo;
}
public int getNumPersone() {
	return numPersone;
}
public EventType getTipo() {
	return tipo;
}
public void setTempo(int tempo) {
	this.tempo = tempo;
}
public void setNumPersone(int numPersone) {
	this.numPersone = numPersone;
}
public void setTipo(EventType tipo) {
	this.tipo = tipo;
}
@Override
public int compareTo(Event o) {
	return this.tempo.compareTo(o.getTempo());
}




}
