package com.mygdx.frogger;

import com.badlogic.gdx.Game;
import com.mygdx.screen.GameScreen;

public class FroggerGame extends Game{

	@Override
	public void create() {
		this.setScreen(new GameScreen());
		
	}

}
