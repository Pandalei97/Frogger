package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public abstract class GameElementLineaire extends GameElement{
	
	float movingTime, speed;
	public GameElementLineaire(Vector2 position, World world, float movingTime, float speed) {
		super(position,world);
		this.movingTime = movingTime;
		this.speed = speed;
	}

	public void refreshPosition() {
		position.x += movingTime * speed;
	}
}
