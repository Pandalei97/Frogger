package com.mygdx.view;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.model.*;


public class TextureFactory {
	private static TextureFactory INSTANCE = null;
	@SuppressWarnings("rawtypes")
	private HashMap<Class, Texture> textures = new HashMap<Class, Texture>(); 
	private Texture fond;
	
	private TextureFactory (){
		
		fond = new Texture("Fond.png");
		
		textures.put(Dead.class, new Texture(Gdx.files.internal("Dead.png")));
		//textures.put(Destination.class, new Texture(Gdx.files.internal("Destination.png")));
		textures.put(Fly.class, new Texture(Gdx.files.internal("Fly.png")));
		textures.put(Frog.class, new Texture(Gdx.files.internal("Frog1.png")));
		//textures.put(Grass.class, new Texture(Gdx.files.internal("Grass.png")));
		//textures.put(Lotus.class, new Texture(Gdx.files.internal("Lotus.png")));
		//textures.put(River.class, new Texture(Gdx.files.internal("River.png")));
		//textures.put(Road.class, new Texture(Gdx.files.internal("Road.png")));
		//textures.put(StartPoint.class, new Texture(Gdx.files.internal("StartPoint.png")));
		textures.put(Turtle.class, new Texture(Gdx.files.internal("Turtle1.png")));
		textures.put(VehicleBlue.class, new Texture(Gdx.files.internal("VehicleBlue.png")));
		textures.put(VehicleBrown.class, new Texture(Gdx.files.internal("VehicleBrown.png")));
		textures.put(VehicleGreen.class, new Texture(Gdx.files.internal("VehicleGreen.png")));
		textures.put(VehicleRed.class, new Texture(Gdx.files.internal("VehicleRed.png")));
		textures.put(VehicleYellow.class, new Texture(Gdx.files.internal("VehicleYellow.png")));
		textures.put(WoodLong.class, new Texture(Gdx.files.internal("WoodLong.png")));
		textures.put(WoodMedium.class, new Texture(Gdx.files.internal("WoodMedium.png")));
		textures.put(WoodShort.class, new Texture(Gdx.files.internal("WoodShort.png")));
		
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
