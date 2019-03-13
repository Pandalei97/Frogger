package com.mygdx.view;

import com.badlogic.gdx.graphics.Texture;

public class TextureUnique implements iTexturable{
	private Texture texture;
	
	public TextureUnique(Texture t) {
		texture = t;
	}
	@Override
	public Texture getTexture() {
		
		return texture;
	}

}
