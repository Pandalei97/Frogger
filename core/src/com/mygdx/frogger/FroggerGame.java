package com.mygdx.frogger;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.screen.MenuScreen;


//Gestion du jeu
public class FroggerGame extends Game {

	private Screen currentScreen;
	
	@Override
	public void create () {
		currentScreen = new MenuScreen(this);
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
	
	public Screen getcurrentScreen() {
		 return currentScreen;
	 }
	
	public void setCurrentScreen(Screen screen) {
		 currentScreen = screen;
		 setScreen(currentScreen);
	 }
}
