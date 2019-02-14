package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class Turtle extends GameElementLineaire{


	public Turtle(Vector2 position, World world, float movingTime, float speed) {
		super(position, world, movingTime, speed);
	}

	@Override
	public float getWidth() {
		return 75;
	}

	@Override
	public float getHeight() {
		return 75;
	}

}
