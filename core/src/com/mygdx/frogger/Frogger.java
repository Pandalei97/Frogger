package com.mygdx.frogger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class Frogger extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fond;
	TextureFactory allElements;
	
	@Override
	public void create () {
		//batch consomme bcp de mémoire, donc on suggère d'en avoir qu'un pour un jeu
		//Et il faut penser à le disposer dans le méthode dispose()
		batch = new SpriteBatch();
		allElements = new TextureFactory();
		fond = new Texture("Fond.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//All SpriteBatch methods must be between .begin() and . end()
		batch.begin();
		// Drawing goes here!
		batch.draw(fond,0,0);
		batch.draw(allElements.getTextureWood(1),0,0);
		batch.draw(allElements.getTextureWood(2),40,50);
		batch.draw(allElements.getTextureDead(),90, 190);
		batch.end();
	}
	
	@Override
	public void dispose () {
		allElements.dispose();
		batch.dispose();
		fond.dispose();
	}
}
