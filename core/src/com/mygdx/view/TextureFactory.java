/**
 * 
 */
package com.mygdx.view;

/**
 * @author pandalei
 *
 */
import java.util.ArrayList;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureFactory {
	private static TextureFactory INSTANCE = null;
	
	private Texture fond = new Texture("Fond.png");
	private Texture model = new Texture("Textures.png");
	private ArrayList<TextureRegion> frogs = new ArrayList<TextureRegion>();
	private ArrayList<TextureRegion> vehicles = new ArrayList<TextureRegion>();
	private ArrayList<TextureRegion> turtles = new ArrayList<TextureRegion>();
	private ArrayList<TextureRegion> woods = new ArrayList<TextureRegion>();
	private TextureRegion river;
	private TextureRegion startPoint;
	private TextureRegion road;
	private TextureRegion dead;
	private TextureRegion fly;
	private TextureRegion grass;
	private TextureRegion destination;
	private TextureRegion lotus;
	
	private TextureFactory (){
		frogs.add(new TextureRegion(model,0,0,52,60));
		frogs.add(new TextureRegion(model,53,25,60,48));
		frogs.add(new TextureRegion(model,112,19,60,54));
		frogs.add(new TextureRegion(model,172,7,56,69));
		frogs.add(new TextureRegion(model,230,0,55,78));
		frogs.add(new TextureRegion(model,283,18,60,56));
		frogs.add(new TextureRegion(model,343,31,55,39));
		
		vehicles.add(new TextureRegion(model,8,405,180,65));
		vehicles.add(new TextureRegion(model,202,404,287,70));
		vehicles.add(new TextureRegion(model,11,483,130,70));
		vehicles.add(new TextureRegion(model,154,483,138,72));
		vehicles.add(new TextureRegion(model,303,483,138,72));
		
		turtles.add(new TextureRegion(model,402,9,73,60));
		turtles.add(new TextureRegion(model,479,9,73,64));
		turtles.add(new TextureRegion(model,6,83,73,67));
		turtles.add(new TextureRegion(model,80,81,73,71));
		turtles.add(new TextureRegion(model,152,83,73,67));
		turtles.add(new TextureRegion(model,227,84,73,66));
		turtles.add(new TextureRegion(model,300,86,73,61));
		turtles.add(new TextureRegion(model,376,88,71,57));
		turtles.add(new TextureRegion(model,452,92,55,48));
		turtles.add(new TextureRegion(model,512,95,45,41));
		
		woods.add(new TextureRegion(model,10,256,360,65));
		woods.add(new TextureRegion(model,385,256,190,65));
		woods.add(new TextureRegion(model,12,326,277,65));
		
		startPoint = new TextureRegion(model,135,158,82,82);
		river = new TextureRegion(model,226,158,82,82);
		road = new TextureRegion(model,317,158,82,82);
		grass = new TextureRegion(model,407,158,82,82);
		destination = new TextureRegion(model,498,158,82,82);
		fly = new TextureRegion(model,82,171,46,50);
		
		lotus = new TextureRegion(model,6,168,63,60);
		dead = new TextureRegion(model,302,333,66,51);
		
		
	}
	public static TextureFactory getInstance(){
		if(INSTANCE == null)
			INSTANCE = new TextureFactory();
		return INSTANCE;
	}
	
	public Texture getFond() {
		return fond;
	}
	
	public TextureRegion getTextureVehicle(int index) {
		return vehicles.get(index);
	}
	
	public TextureRegion getTextureFrog(int index) {
		return frogs.get(index);
	}
	
	public TextureRegion getTextureTurtle(int index) {
		return turtles.get(index);
	}
	
	public TextureRegion getTextureWood(int index) {
		return woods.get(index);
	}
	
	public TextureRegion getTextureStartPoint() {
		return startPoint;
	}
	
	public TextureRegion getTextureRiver() {
		return river;
	}
	
	public TextureRegion getTextureRoad() {
		return road;
	}
	
	public TextureRegion getTextureGrass() {
		return grass;
	}
	
	public TextureRegion getTextureDestination() {
		return destination;
	}
	
	public TextureRegion getTextureFly() {
		return fly;
	}
	
	public TextureRegion getTextureLotus() {
		return lotus;
	}
	
	public TextureRegion getTextureDead() {
		return dead;
	}
	
	public void dispose () {
		model.dispose();
	}
	
	

}
