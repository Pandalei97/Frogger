package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public abstract class Wood extends GameElementLineaire{
	public Wood(Vector2 position, World world, float movingTime, float speed) {
		super(position, world, movingTime, speed);
	}
}
