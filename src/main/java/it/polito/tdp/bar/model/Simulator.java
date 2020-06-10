package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;
import it.polito.tdp.bar.model.Event;

public class Simulator {
	Map<Integer,Tavolo> tavoli;
	PriorityQueue<Event> queue;
	List<Tavolo> tav;
	List<Event> lista;
	int clienti;
	int clientiInsoddisfatti;

	public Simulator() {
		tavoli=new HashMap();
		queue=new PriorityQueue();
		lista=new ArrayList();
		clienti=0;
		clientiInsoddisfatti=0;
		tav=new ArrayList();
	}

	public void init() {
		tavoli.put(0,new Tavolo(10,false,0));
		tav.add(0,new Tavolo(10,false,0));
		tavoli.put(1,new Tavolo(10,false,1));
		tav.add(1,new Tavolo(10,false,1));
		for(int i=0;i<4;i++) {
			tavoli.put(i+2,new Tavolo(8,false,i+2));
			tav.add(i+2,new Tavolo(8,false,i+2));
		}
		for(int i=0;i<4;i++) {
			tavoli.put(i+6,new Tavolo(6,false,i+6));
			tav.add(i+6,new Tavolo(6,false,i+6));
			}
		for(int i=0;i<5;i++) {
			tavoli.put(i+10,new Tavolo(4,false,i+10));
			tav.add(i+10,new Tavolo(4,false,i+10));
		}
		for(int i=0;i<15;i++) {
			int tempo=(int) (Math.random()*10)+1;
			int persone=(int)(Math.random()*10)+1;
			if(i==0) {
				Event e =new Event(tempo,persone,EventType.NEW_CLIENTS);
				queue.add(e);
				lista.add(e);
			}
			else {
				Event e =new Event(tempo+lista.get(i-1).getTempo(),persone,EventType.NEW_CLIENTS);
				queue.add(e);
				lista.add(e);
			}
				
		}
		
	}
	
	public void run() {
		while(!queue.isEmpty()) {
			Event e=queue.poll();
			this.processEvent(e);
		}
	}

	private void processEvent(Event e) {
		switch(e.getTipo()) {
		
		case NEW_CLIENTS: 
			boolean b=false;
			for(Tavolo t: tav) {
				if(t.getPosti()>=e.getNumPersone()&&b==false&&t.occupato==false) {
					//System.out.println(t.getId());
					//System.out.println(e.getNumPersone());
					t.setOccupato();
					b=true;
					int durata=(int)(Math.random()*61)+60;
					Event nuovo=new Event(durata+e.getTempo(),0,EventType.TABLE_RETURNED);
					nuovo.setIdTavolo(t.getId());
					queue.add(nuovo);
					}
			}
			if(b==false) {
				this.clienti++;
				this.clientiInsoddisfatti++;
			}
			else
				this.clienti++;
				
		case TABLE_RETURNED :
		
		//System.out.println(e.getIdTavolo());
		Tavolo t=tavoli.get(e.getIdTavolo());
		t.occupato=false;
		
		}
		
	}
	
	
	
	
}
