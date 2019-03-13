package com.mygdx.model;

import com.badlogic.gdx.math.Vector2;

public class VehicleBlue extends Vehicle{

	

	public VehicleBlue(Vector2 position, World world, float movingTime, float speed) {
		super(position, world, movingTime, speed);
	}

	@Override
	public float getWidth() {
		return 127;
	}

	@Override
	public float getHeight() {
		return 67;
	}


}
