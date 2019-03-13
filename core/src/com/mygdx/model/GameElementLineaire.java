package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public abstract class GameElementLineaire extends GameElement{
	
	private float speed;
	public GameElementLineaire(Vector2 position, World world, float frequency, float speed) {
		super(position,world,frequency);
		this.speed = speed;
	}

	public void refreshPosition() {
		if(position.x > 600)
			position.x = -200;
		position.x += frequency * speed;
	}
	
	public float getSpeed() {
		return speed;
	}
}
