package com.mygdx.frogger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.screen.GameScreen;


//Gestion du jeu
public class FroggerGame extends Game {

	private GameScreen currentScreen;
	
	@Override
	public void create () {
		currentScreen = new GameScreen();
		setScreen(currentScreen);
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
