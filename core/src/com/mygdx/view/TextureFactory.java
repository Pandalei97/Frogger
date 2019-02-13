package com.mygdx.view;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.model.*;


public class TextureFactory {
	private static TextureFactory INSTANCE = null;
	private HashMap<Class, Texture> textures = new HashMap<Class, Texture>(); 
	private Texture fond;
	/*
	private Texture fond;
	//private Texture model = new Texture("Textures.png");
	private ArrayList<Texture> frogs = new ArrayList<Texture>();
	private ArrayList<Texture> turtles = new ArrayList<Texture>();
	private Texture woodLong, woodMedium, woodShort;
	private Texture vehicleBlue, vehicleBrown, vehicleGreen, vehicleRed, vehicleYellow;
	private Texture river;
	private Texture startPoint;
	private Texture road;
	private Texture dead;
	private Texture fly;
	private Texture grass;
	private Texture destination;
	private Texture lotus;
	*/
	
	private TextureFactory (){
		
		fond = new Texture("Fond.png");
		/*
		frogs.add(new Texture("Frog1.png"));
		frogs.add(new Texture("Frog2.png"));
		frogs.add(new Texture("Frog3.png"));
		frogs.add(new Texture("Frog4.png"));
		frogs.add(new Texture("Frog5.png"));
		frogs.add(new Texture("Frog6.png"));
		frogs.add(new Texture("Frog7.png"));
		
		vehicleBlue = new Texture("VehicleBlue.png");
		vehicleBrown = new Texture("VehicleBrown.png");
		vehicleGreen = new Texture("VehicleGreen.png");
		vehicleRed= new Texture("VehicleRed.png");
		vehicleYellow = new Texture("VehicleYellow.png");
	
		
		turtles.add(new Texture("Turtle1.png"));
		turtles.add(new Texture("Turtle2.png"));
		turtles.add(new Texture("Turtle3.png"));
		turtles.add(new Texture("Turtle4.png"));
		turtles.add(new Texture("Turtle5.png"));
		turtles.add(new Texture("Turtle6.png"));
		turtles.add(new Texture("Turtle7.png"));
		turtles.add(new Texture("Turtle8.png"));
		turtles.add(new Texture("Turtle9.png"));
		turtles.add(new Texture("Turtle10.png"));
		turtles.add(new Texture("Turtle11.png"));
		
		
		woodLong = new Texture("WoodLong.png");
		woodMedium = new Texture("WoodMedium.png");
		woodShort = new Texture("WoodShort.png");
		
		startPoint = new Texture("StartPoint.png");
		river = new Texture("River.png");
		road = new Texture("Road.png");
		grass = new Texture("Grass.png");
		destination = new Texture("Destination.png");
		fly = new Texture("Fly.png");
		
		lotus = new Texture("Lotus.png");
		dead = new Texture("Dead.png");
		*/
		
		textures.put(Fly.class, new Texture(Gdx.files.internal("Fly.png")));
		textures.put(Frog.class, new Texture(Gdx.files.internal("Frog1.png")));
		textures.put(VehicleRed.class, new Texture(Gdx.files.internal("VehicleRed.png")));
		textures.put(WoodLong.class, new Texture(Gdx.files.internal("WoodLong.png")));
		
	}
	
	public static TextureFactory getInstance(){
		if(INSTANCE == null)
			INSTANCE = new TextureFactory();
		return INSTANCE;
	}
	
	
	public static void reset() {
		INSTANCE = null;
	}
	
	public Texture getTexture(Class<?> c) {
		return  textures.get(c);
	}
	
	public Texture getFond() {
		return fond;
	}
	
	

}
