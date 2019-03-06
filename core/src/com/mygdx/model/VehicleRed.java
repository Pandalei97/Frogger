package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class VehicleRed extends GameElementLineaire{

	

	public VehicleRed(Vector2 position, World world, float movingTime, float speed) {
		super(position, world, movingTime, speed);
	}

	@Override
	public float getWidth() {
		return 175;
	}

	@Override
	public float getHeight() {
		return 65;
	}

}
