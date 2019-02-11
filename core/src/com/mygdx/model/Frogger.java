package com.mygdx.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.screen.GameScreen;



public class Frogger extends ApplicationAdapter {
	private GameScreen currentScreen;
	private boolean init = false;
	
	public void setScreen(GameScreen screen) {
		currentScreen = screen;
		currentScreen.show();
		currentScreen.render(0);
	}
	
	@Override
	public void create () {
		setScreen(new GameScreen());
	}

	@Override
	public void render () {
		float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), 1.0f / 60.0f);
        if (currentScreen != null)
           currentScreen.render(deltaTime);
	}
	
	@Override
	public void dispose () {
		
	}
	
}
