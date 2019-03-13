package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class VehicleBrown extends Vehicle{

	
	public VehicleBrown(Vector2 position, World world, float movingTime, float speed) {
		super(position, world, movingTime, speed);
	}

	@Override
	public float getWidth() {
		return 283;
	}

	@Override
	public float getHeight() {
		return 65;
	}

}
