package com.mygdx.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class World implements Iterable<GameElement>{
	private Dead dead;
	private Fly fly;
	private Frog frog;
	private ArrayList<Turtle> turtles = new ArrayList<Turtle>();
	private ArrayList<VehicleBlue> vehiclesBlue = new ArrayList<VehicleBlue>();
	private ArrayList<VehicleBrown>vehiclesBrown;
	private ArrayList<VehicleGreen> vehiclesGreen = new ArrayList<VehicleGreen>();
	private ArrayList<VehicleRed>vehiclesRed;
	private ArrayList<VehicleYellow>vehiclesYellow;
	private ArrayList<WoodLong>woodsLong;
	private ArrayList<WoodMedium>woodsMedium;
	private ArrayList<WoodShort>woodsShort;
	
	
	public World(){
		@SuppressWarnings("rawtypes")
		HashMap<String, ArrayList> listeElem = null;
		try {
			listeElem = ConfigPos.getInstance().getElements();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Float> donnees;
		for(Map.Entry<String, ArrayList> entry : listeElem.entrySet()) {
			donnees = entry.getValue();
			switch(entry.getKey()) {
			case "Frog":
				frog = new Frog(new Vector2(donnees.get(0),donnees.get(1)),this);
				break;
			case "Fly":
				fly = new Fly(new Vector2(donnees.get(0),donnees.get(1)),this);
				break;
			case "VehicleGreen":
				vehiclesGreen.add(new VehicleGreen(new Vector2(donnees.get(0),donnees.get(1)),this,donnees.get(2),donnees.get(3)));
				break;
			}
			
		}
		
	}
	
	public Frog getFrog() {
		return frog;
	}
	
	public Fly getFly() {
		return fly;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Iterator<GameElement> iterator() {
		ArrayList<GameElement> list = new ArrayList<GameElement>();
		
		
		list.add(fly);
		//list.add(vehicleBlue);
		for(VehicleGreen e : vehiclesGreen) {
			list.add(e);
		}
		//list.add(vehicleGreen);
		list.add(frog);
		//return new WorldIterator(this);
		return list.iterator();
	}

}
