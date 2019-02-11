package com.mygdx.model;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class World implements Iterable<GameElement>{
	private Frog frog;
	private GameElement turtle, wood, river, startPoint, road, dead, grass, destination, lotus;
	private Fly fly;
	private Vehicle vehicleBlue, vehiculeGreen, vehiculeYellow, vehiculeRed, vehiculeBrown;
	public World(){
		
		fly = new Fly(new Vector2(20,630), this);
		vehicleBlue = new Vehicle(new Vector2(0,30),this);
		vehiculeGreen = new Vehicle(new Vector2(0,90),this); 
		vehiculeYellow  = new Vehicle(new Vector2(0,150),this);
		vehiculeRed  = new Vehicle(new Vector2(0,170),this);
		vehiculeBrown  = new Vehicle(new Vector2(0,280),this);
		frog = new Frog(new Vector2(0,0),this);
	}
	
	public Fly getFly() {
		return fly;
	}
	
	public Vehicle getVehicleBlue() {
		return vehicleBlue;
	}

	public Vehicle getVehiculeGreen() {
		return vehiculeGreen;
	}


	public Vehicle getVehiculeYellow() {
		return vehiculeYellow;
	}

	public Vehicle getVehiculeRed() {
		return vehiculeRed;
	}

	public Vehicle getVehiculeBrown() {
		return vehiculeBrown;
	}
	
	public Frog getFrog() {
		return frog;
	}
	
	@Override
	public Iterator<GameElement> iterator() {
		ArrayList<GameElement> list = new ArrayList<GameElement>();
		list.add(fly);
		list.add(vehicleBlue);
		list.add(vehiculeBrown);
		//return new WorldIterator(this);
		return list.iterator();
	}

}
