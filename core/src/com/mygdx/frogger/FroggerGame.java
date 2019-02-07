package com.mygdx.frogger;

import com.badlogic.gdx.Game;

public class FroggerGame extends Game{

	@Override
	public void create() {
		this.setScreen(new GameScreen());
		
	}

}
