package com.mygdx.view;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureTurtle implements iTexturable{
	private ArrayList<Texture> tabTexture = new ArrayList<Texture>();
	private int textureActuel = 0;
	
	public TextureTurtle() {
		tabTexture.add(new Texture(Gdx.files.internal("Turtle1.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Turtle2.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Turtle3.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Turtle4.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Turtle5.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Turtle6.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Turtle7.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Turtle8.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Turtle9.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Turtle10.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Turtle11.png")));
		
	}
	
	
	void refreshIndex() {
		if(textureActuel > 0)
			textureActuel --;
		else
			textureActuel = 10;
	}
	

	@Override
	public Texture getTexture () {
	    return tabTexture.get(textureActuel);
	}
	
	void setTextureActuel(int i) {
		textureActuel = i;
	}


}