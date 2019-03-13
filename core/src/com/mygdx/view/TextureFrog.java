package com.mygdx.view;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.model.Frog;

public class TextureFrog implements iTexturable{
	private ArrayList<Texture> tabTexture = new ArrayList<Texture>();
	private int textureActuel = 0;
	
	public TextureFrog() {
		tabTexture.add(new Texture(Gdx.files.internal("Frog1.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Frog2.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Frog3.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Frog4.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Frog5.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Frog6.png")));
		tabTexture.add(new Texture(Gdx.files.internal("Frog7.png")));
		
	}
	
	
	void refreshIndex() {
		if(textureActuel > 0)
			textureActuel --;
	}
	
	void jump() {
		textureActuel = 6;
	}

	@Override
	public Texture getTexture () {
	    return tabTexture.get(textureActuel);
	}
	
	void setTextureActuel(int i) {
		textureActuel = i;
	}


}
