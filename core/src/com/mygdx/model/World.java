package com.mygdx.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.outils.Pair;

public class World implements Iterable<GameElement>{
	private Dead dead;
	private Fly fly;
	private Frog frog;
	private ArrayList<Turtle> turtles = new ArrayList<Turtle>();
	private ArrayList<VehicleBlue> vehiclesBlue = new ArrayList<VehicleBlue>();
	private ArrayList<VehicleBrown>vehiclesBrown = new ArrayList<VehicleBrown>();
	private ArrayList<VehicleGreen> vehiclesGreen = new ArrayList<VehicleGreen>();
	private ArrayList<VehicleRed>vehiclesRed = new ArrayList<VehicleRed>();
	private ArrayList<VehicleYellow>vehiclesYellow = new ArrayList<VehicleYellow>();
	private ArrayList<WoodLong>woodsLong = new ArrayList<WoodLong>();
	private ArrayList<WoodMedium>woodsMedium = new ArrayList<WoodMedium>();
	private ArrayList<WoodShort>woodsShort = new ArrayList<WoodShort>();
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public World(){
		ArrayList<Pair> listeElem = null;
		try {
			listeElem = ConfigPos.getInstance().getElements();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Float> donnees;
		for(Pair<String,ArrayList> obj : listeElem) {
			donnees = obj.getValue();
			switch(obj.getKey()) {
			case "Fly":
				fly = new Fly(new Vector2(donnees.get(0),donnees.get(1)),this, donnees.get(2));
				break;
			case "Frog":
				frog = new Frog(new Vector2(donnees.get(0),donnees.get(1)),this, donnees.get(2), (int)donnees.get(3).floatValue());
				break;
			case "Turtle":
				turtles.add(new Turtle(new Vector2(donnees.get(0),donnees.get(1)),this, donnees.get(2),donnees.get(3)));
				break;
			case "VehicleBlue":
				vehiclesBlue.add(new VehicleBlue(new Vector2(donnees.get(0),donnees.get(1)),this,donnees.get(2),donnees.get(3)));
				break;
			case "VehicleBrown":
				vehiclesBrown.add(new VehicleBrown(new Vector2(donnees.get(0),donnees.get(1)),this,donnees.get(2),donnees.get(3)));
				break;
			case "VehicleGreen":
				vehiclesGreen.add(new VehicleGreen(new Vector2(donnees.get(0),donnees.get(1)),this,donnees.get(2),donnees.get(3)));
				break;
			case "VehicleRed":
				vehiclesRed.add(new VehicleRed(new Vector2(donnees.get(0),donnees.get(1)),this,donnees.get(2),donnees.get(3)));
				break;
			case "VehicleYellow":
				vehiclesYellow.add(new VehicleYellow(new Vector2(donnees.get(0),donnees.get(1)),this,donnees.get(2),donnees.get(3)));
				break;
			case "WoodLong":
				woodsLong.add(new WoodLong(new Vector2(donnees.get(0),donnees.get(1)),this,donnees.get(2),donnees.get(3)));
				break;
			case "WoodMedium":
				woodsMedium.add(new WoodMedium(new Vector2(donnees.get(0),donnees.get(1)),this,donnees.get(2),donnees.get(3)));
				break;
			case "WoodShort":
				woodsShort.add(new WoodShort(new Vector2(donnees.get(0),donnees.get(1)),this,donnees.get(2),donnees.get(3)));
				break;
			
			default:
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
	
	public int getNbVie() {
		return frog.getNbVie();
	}
	
	@Override
	public Iterator<GameElement> iterator() {
		ArrayList<GameElement> list = new ArrayList<GameElement>();
		list.add(fly);
		list.add(frog);
		for(Turtle e : turtles) {
			//System.out.println(e);
			list.add(e);
		}
		for(VehicleBlue e : vehiclesBlue) {
			//System.out.println(e);
			list.add(e);
		}
		for(VehicleBrown e : vehiclesBrown) {
			//System.out.println(e);
			list.add(e);
		}
		for(VehicleGreen e : vehiclesGreen) {
			//System.out.println(e);
			list.add(e);
		}
		for(VehicleRed e : vehiclesRed) {
			//System.out.println(e);
			list.add(e);
		}
		for(VehicleYellow e : vehiclesYellow) {
			//System.out.println(e);
			list.add(e);
		}
		for(WoodLong e : woodsLong) {
			//System.out.println(e);
			list.add(e);
		}
		for(WoodMedium e : woodsMedium) {
			//System.out.println(e);
			list.add(e);
		}
		for(WoodShort e : woodsShort) {
			//System.out.println(e);
			list.add(e);
		}
		return list.iterator();
	}

}
