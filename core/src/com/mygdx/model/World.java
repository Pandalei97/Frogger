package com.mygdx.model;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class World implements Iterable<GameElement>{
	private Frog frog;
	private GameElement turtle, wood, river, startPoint, road, dead, grass, destination, lotus;
	private Fly fly;
	private VehicleBlue vehicleBlue;
	private VehicleGreen vehicleGreen;
	public World(){
		
		fly = new Fly(new Vector2(20,630), this);
		vehicleBlue = new VehicleBlue(new Vector2(0,30),this);
		vehicleGreen = new VehicleGreen(new Vector2(0,90),this); 
		
		frog = new Frog(new Vector2(0,0),this);
	}
	
	public Fly getFly() {
		return fly;
	}
	
	public VehicleBlue getVehicleBlue() {
		return vehicleBlue;
	}

	public VehicleGreen getVehiculeGreen() {
		return vehicleGreen;
	}
	
	public Frog getFrog() {
		return frog;
	}
	
	@Override
	public Iterator<GameElement> iterator() {
		ArrayList<GameElement> list = new ArrayList<GameElement>();
		list.add(fly);
		list.add(vehicleBlue);
		list.add(vehicleGreen);
		//return new WorldIterator(this);
		return list.iterator();
	}

}
